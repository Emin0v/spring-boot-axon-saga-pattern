package com.company.service.impl;

import com.company.commands.CreateProductCommand;
import com.company.dto.ProductDto;
import com.company.query.FindProductQuery;
import com.company.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Override
    public String createProduct(ProductDto dto) {
        return commandGateway.sendAndWait(
                CreateProductCommand.builder()
                        .name(dto.getName())
                        .count(dto.getCount())
                        .build()
        );
    }

    @Override
    public CompletableFuture<ProductDto> getProduct(String uuid) {
        return queryGateway.query(new FindProductQuery(uuid),
                ResponseTypes.instanceOf(ProductDto.class));
    }
}
