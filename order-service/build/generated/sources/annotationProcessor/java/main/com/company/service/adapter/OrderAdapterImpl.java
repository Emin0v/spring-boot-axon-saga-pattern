package com.company.service.adapter;

import com.company.domain.OrderEntity;
import com.company.dto.OrderResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-26T00:55:20+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class OrderAdapterImpl implements OrderAdapter {

    @Override
    public OrderResponseDto map(OrderEntity entity) {
        if ( entity == null ) {
            return null;
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();

        orderResponseDto.setProductUuid( entity.getProductUuid() );
        orderResponseDto.setCount( entity.getCount() );
        orderResponseDto.setPrice( entity.getPrice() );

        return orderResponseDto;
    }
}
