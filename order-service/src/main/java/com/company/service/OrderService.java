package com.company.service;


import com.company.dto.OrderCreateDto;

public interface OrderService {

    boolean createOrder(OrderCreateDto orderCreateDto);
}
