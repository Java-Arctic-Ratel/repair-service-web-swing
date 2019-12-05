package com.epam.repair.exception;

/**
 * The type Order not found exception.
 */
public class OrderNotFoundException extends RuntimeException {
    private static final String ORDER_NOT_FOUND = "Order not found! Please check the connection to the server";

    /**
     * Instantiates a new Order not found exception.
     */
    public OrderNotFoundException() {
        super(ORDER_NOT_FOUND);
    }
}