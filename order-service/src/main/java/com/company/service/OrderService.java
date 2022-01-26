package com.company.service;


import com.company.dto.OrderCreateDto;
import com.company.dto.OrderResponseDto;

import java.util.concurrent.CompletableFuture;

public interface OrderService {

    String createOrder(OrderCreateDto orderCreateDto);

    CompletableFuture<OrderResponseDto> getOrder(String orderId);
}
