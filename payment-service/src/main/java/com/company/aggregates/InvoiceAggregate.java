package com.company.aggregates;

import com.company.commands.CreateInvoiceCommand;
import com.company.events.InvoiceCreatedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
@Data
public class InvoiceAggregate {

    @AggregateIdentifier
    private String paymentId;

    private String productUuid;

    private String orderId;

    private InvoiceStatus invoiceStatus;

    @CommandHandler
    public InvoiceAggregate(CreateInvoiceCommand command){
        AggregateLifecycle.apply(InvoiceCreatedEvent.builder()
                .paymentId(command.getPaymentId())
                .orderId(command.getPaymentId())
                .productUuid(command.getProductUuid())
                .build()
        );
    }

    @EventSourcingHandler
    protected void on(InvoiceCreatedEvent event){
        this.paymentId = event.getPaymentId();
        this.orderId = event.getOrderId();
        this.productUuid = event.getProductUuid();
        this.invoiceStatus = InvoiceStatus.PAID;

    }

}
