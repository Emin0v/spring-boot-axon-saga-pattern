package com.company.service;

import com.company.dto.ProductDto;

import java.util.concurrent.CompletableFuture;

public interface ProductService {

    String createProduct(ProductDto dto);

    CompletableFuture<ProductDto> getProduct(String uuid);
}
