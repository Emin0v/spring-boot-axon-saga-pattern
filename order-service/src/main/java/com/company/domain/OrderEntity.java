package com.company.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

import static com.company.domain.OrderEntity.TABLE_NAME;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = TABLE_NAME)
public class OrderEntity {
    public static final String TABLE_NAME = "order_table";

    @Id
    private String orderId;

    private String productUuid;

    private Integer count;

    private BigDecimal price;

}
