package com.company.projector;

import com.company.domain.OrderEntity;
import com.company.dto.OrderResponseDto;
import com.company.events.OrderCreatedEvent;
import com.company.exception.OrderNotFoundException;
import com.company.query.FindOrderQuery;
import com.company.repository.OrderEntityRepository;
import com.company.service.adapter.OrderAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderProjector {

    private final OrderEntityRepository repository;
    private final OrderAdapter adapter;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        OrderEntity orderEntity = OrderEntity.builder()
                .orderId(event.getOrderId())
                .productUuid(event.getProductUuid())
                .count(event.getCount())
                .price(event.getPrice())
                .build();

        repository.save(orderEntity);

        log.info("orderEntity saved");
    }

    @QueryHandler
    @Transactional
    public OrderResponseDto handle(FindOrderQuery query) {
        OrderEntity orderEntity = repository.findById(query.getOrderId()).orElseThrow(() ->
                new OrderNotFoundException(query.getOrderId()));

        return adapter.map(orderEntity);
    }
}
