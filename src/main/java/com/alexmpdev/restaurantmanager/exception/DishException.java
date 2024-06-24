package com.alexmpdev.restaurantmanager.exception;

public class DishException extends RuntimeException {
    public static final String ERROR_NOT_FOUND = "Dish not found";
    public DishException(String message) {
        super(message);
    }
}