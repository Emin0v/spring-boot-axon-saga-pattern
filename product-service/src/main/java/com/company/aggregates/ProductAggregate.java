package com.company.aggregates;

import com.company.commands.CreateProductCommand;
import com.company.commands.UpdateStockCommand;
import com.company.events.ProductCreatedEvent;
import com.company.events.StockUpdatedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Slf4j
@Aggregate
@NoArgsConstructor
@Data
public class ProductAggregate {

    @AggregateIdentifier
    private String productUuid;

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

    @CommandHandler
    public void handle(UpdateStockCommand command){
        AggregateLifecycle.apply(StockUpdatedEvent.builder()
                .productUuid(command.getProductUuid())
                .count(command.getCount())
                .build()
        );
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event){
        log.info("Product created event processing...");
        this.productUuid = event.getUuid();
        this.name = event.getName();
        this.count = event.getCount();
    }

    @EventSourcingHandler
    public void on(StockUpdatedEvent event){

        log.info("processing Stock updated event ");

    }
}
