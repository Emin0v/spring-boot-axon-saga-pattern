package com.company.sagas;

import com.company.commands.CreateInvoiceCommand;
import com.company.events.OrderCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import java.util.UUID;

@Saga
public class OrderManagementSaga {

    private CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent event){
        String paymentId = UUID.randomUUID().toString();

        System.out.println("Saga started");

        SagaLifecycle.associateWith("paymentId",paymentId);

        commandGateway.send(
                CreateInvoiceCommand.builder()
                        .orderId(event.getOrderId())
                        .paymentId(paymentId)
                        .build()
        );
    }


}
