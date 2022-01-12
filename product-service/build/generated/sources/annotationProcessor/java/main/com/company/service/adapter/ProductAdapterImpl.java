package com.company.service.adapter;

import com.company.dto.ProductDto;
import com.company.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-12T22:43:26+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class ProductAdapterImpl implements ProductAdapter {

    @Override
    public ProductDto map(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setName( product.getName() );
        productDto.setCount( product.getCount() );

        return productDto;
    }
}
