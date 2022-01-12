package com.company.service.impl;

import com.company.commands.CreateProductCommand;
import com.company.dto.ProductDto;
import com.company.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final CommandGateway commandGateway;

    @Override
    public String createProduct(ProductDto dto) {
        return commandGateway.sendAndWait(
                CreateProductCommand.builder()
                        .name(dto.getName())
                        .count(dto.getCount())
                        .build()
        );
    }
}
