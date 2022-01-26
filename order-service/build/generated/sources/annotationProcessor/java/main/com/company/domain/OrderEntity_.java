package com.company.domain;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderEntity.class)
public abstract class OrderEntity_ {

	public static volatile SingularAttribute<OrderEntity, String> productUuid;
	public static volatile SingularAttribute<OrderEntity, String> orderId;
	public static volatile SingularAttribute<OrderEntity, BigDecimal> price;
	public static volatile SingularAttribute<OrderEntity, Integer> count;

	public static final String PRODUCT_UUID = "productUuid";
	public static final String ORDER_ID = "orderId";
	public static final String PRICE = "price";
	public static final String COUNT = "count";

}

