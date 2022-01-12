package com.company.controller;

import com.company.dto.ProductDto;
import com.company.query.FindProductQuery;
import com.company.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final QueryGateway queryGateway;

    @PostMapping
    public ResponseEntity<String> createProduct(ProductDto dto){
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping("/{uuid}")
    public CompletableFuture<ProductDto> handle(@PathVariable("uuid") String uuid) {
        return queryGateway.query(new FindProductQuery(uuid),
                ResponseTypes.instanceOf(ProductDto.class));
    }

}
