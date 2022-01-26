package com.company.controller;

import com.company.dto.OrderCreateDto;
import com.company.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public void getOrder(@PathVariable("orderId") String orderId){
        orderService.getOrder(orderId);
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderCreateDto orderCreateDto){
        return ResponseEntity.ok(orderService.createOrder(orderCreateDto));
    }
}
