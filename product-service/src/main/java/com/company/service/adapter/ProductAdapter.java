package com.company.service.adapter;

import com.company.dto.ProductDto;
import com.company.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductAdapter {

     ProductDto map(Product product);
}
