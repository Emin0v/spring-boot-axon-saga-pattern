package com.company.projector;

import com.company.dto.ProductDto;
import com.company.entity.Product;
import com.company.events.ProductCreatedEvent;
import com.company.exception.ProductNotFoundException;
import com.company.query.FindProductQuery;
import com.company.repository.ProductRepository;
import com.company.service.adapter.ProductAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductProjector {

    private final ProductRepository productRepository;
    private final ProductAdapter productAdapter;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product = Product.builder()
                .uuid(event.getUuid())
                .name(event.getName())
                .count(event.getCount())
                .build();

        productRepository.save(product);

        log.info("productRepository save");

    }

    @QueryHandler
    @Transactional
    public ProductDto handle(FindProductQuery query) {
        Product product = productRepository.findById(query.getUuid()).orElseThrow(() ->
                new ProductNotFoundException(query.getUuid()));

        return productAdapter.map(product);
    }

}
