package com.company.service.impl;

import com.company.commands.CreateOrderCommand;
import com.company.dto.OrderCreateDto;
import com.company.dto.OrderResponseDto;
import com.company.query.FindOrderQuery;
import com.company.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Override
    public String createOrder(OrderCreateDto orderCreateDto) {
        return commandGateway.sendAndWait(
                CreateOrderCommand.builder()
                        .orderId(UUID.randomUUID().toString())
                        .productUuid(orderCreateDto.getProductUuid())
                        .count(orderCreateDto.getCount())
                        .price(orderCreateDto.getPrice())
                        .build()
        );
    }

    @Override
    public CompletableFuture<OrderResponseDto> getOrder(String orderId) {
        return queryGateway.query(new FindOrderQuery(orderId),
                ResponseTypes.instanceOf(OrderResponseDto.class));
    }
}
