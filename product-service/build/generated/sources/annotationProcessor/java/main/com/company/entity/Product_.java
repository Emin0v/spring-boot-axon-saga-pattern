package com.company.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, Integer> count;
	public static volatile SingularAttribute<Product, String> uuid;

	public static final String NAME = "name";
	public static final String COUNT = "count";
	public static final String UUID = "uuid";

}

