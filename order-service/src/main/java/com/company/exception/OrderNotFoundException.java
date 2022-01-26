package com.company.exception;

public class OrderNotFoundException extends RuntimeException{
    public static final String MESSAGE = "Order not found: [%s]";

    public OrderNotFoundException(String uuid){
        super(String.format(MESSAGE,uuid));
    }
}
