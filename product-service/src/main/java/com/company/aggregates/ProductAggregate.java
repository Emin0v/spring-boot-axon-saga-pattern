package com.company.aggregates;

import com.company.commands.CreateProductCommand;
import com.company.events.ProductCreatedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
@NoArgsConstructor
@Data
public class ProductAggregate {

    @AggregateIdentifier
    private String uuid;

    private String name;
    private Integer count;

    @CommandHandler
    public ProductAggregate(CreateProductCommand command){
        AggregateLifecycle.apply(ProductCreatedEvent.builder()
                .uuid(UUID.randomUUID().toString())
                .name(command.getName())
                .count(command.getCount())
                .build()
        );
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event){
        this.uuid = event.getUuid();
        this.name = event.getName();
        this.count = event.getCount();
    }
}
