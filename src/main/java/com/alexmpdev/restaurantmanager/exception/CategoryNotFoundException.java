package com.alexmpdev.restaurantmanager.exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
