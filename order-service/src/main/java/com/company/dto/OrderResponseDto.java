package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

    private Long id;

    private String productUuid;

    private Integer count;

    private BigDecimal price;
}
