package com.company.controller;

import com.company.dto.ProductDto;
import com.company.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDto dto){
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping("/{uuid}")
    public CompletableFuture<ProductDto> getProduct(@PathVariable("uuid") String uuid) {
        return productService.getProduct(uuid);
    }

}
