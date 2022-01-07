package com.company.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = Product.PRODUCT_TABLE)
public class Product {
    public static final String PRODUCT_TABLE = "product";

    @Id
    private String uuid;

    private String name;

    @Positive
    private String count;
}
