package com.company.service.adapter;

import com.company.domain.OrderEntity;
import com.company.dto.OrderResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderAdapter {

    OrderResponseDto map(OrderEntity entity);
}
