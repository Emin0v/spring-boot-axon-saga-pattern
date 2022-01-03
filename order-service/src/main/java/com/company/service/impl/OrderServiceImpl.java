package com.company.service.impl;

import com.company.commands.CreateOrderCommand;
import com.company.dto.OrderCreateDto;
import com.company.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CommandGateway commandGateway;

    @Override
    public boolean createOrder(OrderCreateDto orderCreateDto) {
        return commandGateway.send(
                CreateOrderCommand.builder()
                        .orderId(UUID.randomUUID().toString())
                        .productUuid(orderCreateDto.getProductUuid())
                        .count(orderCreateDto.getCount())
                        .price(orderCreateDto.getPrice())
                        .build()
        ).isDone();
    }
}
