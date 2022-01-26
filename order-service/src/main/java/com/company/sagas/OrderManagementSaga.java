package com.company.sagas;

import com.company.commands.CreateInvoiceCommand;
import com.company.commands.UpdateStockCommand;
import com.company.events.InvoiceCreatedEvent;
import com.company.events.OrderCreatedEvent;
import com.company.events.StockUpdatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import javax.inject.Inject;
import java.util.UUID;

@Saga
@Slf4j
public class OrderManagementSaga {

    @Inject
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent event){
        String paymentId = UUID.randomUUID().toString();

        String productUuid = event.getProductUuid();

        System.out.println("Saga started");

        SagaLifecycle.associateWith("paymentId",paymentId);
        SagaLifecycle.associateWith("productUuid",productUuid);

        commandGateway.sendAndWait(
                CreateInvoiceCommand.builder()
                        .orderId(event.getOrderId())
                        .paymentId(paymentId)
                        .productUuid(productUuid)
                        .build()
        );

        commandGateway.send(
                UpdateStockCommand.builder()
                        .productUuid(event.getProductUuid())
                        .count(event.getCount())
                        .build()
        );
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(InvoiceCreatedEvent event){



        log.info("Invoice created event called in OrderManagementSaga");

    }

    @SagaEventHandler(associationProperty = "productUuid")
    public void handle(StockUpdatedEvent event){

        log.info("Updated stock event called in OrderManagementSaga");

    }

}
