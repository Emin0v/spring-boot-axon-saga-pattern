package com.company.aggregates;

import com.company.commands.CreateOrderCommand;
import com.company.events.OrderCreatedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Slf4j
@Data
@Aggregate
@NoArgsConstructor
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;

    private String productUuid;

    private Integer count;

    private BigDecimal price;

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {
        log.info("Received create order command");
        AggregateLifecycle.apply(OrderCreatedEvent.builder()
                .orderId(command.getOrderId())
                .productUuid(command.getProductUuid())
                .count(command.getCount())
                .price(command.getPrice())
                .build());
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event){
        log.info("Order created event processing ... in OrderAggregate");
        this.orderId = event.getOrderId();
        this.productUuid = event.getProductUuid();
        this.count = event.getCount();
        this.price = event.getPrice();
    }

}
