package edu.ali.product_api.exceptions;

public class InvalidProductException  extends RuntimeException {
    public InvalidProductException(String message) {
        super(message);
    }
}