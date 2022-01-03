package com.company.controllers;

import com.company.dto.OrderCreateDto;
import com.company.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Boolean> createOrder(@RequestBody OrderCreateDto orderCreateDto){
       return ResponseEntity.ok(orderService.createOrder(orderCreateDto));
    }

}
