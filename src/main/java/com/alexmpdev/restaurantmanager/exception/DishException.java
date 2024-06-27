package com.alexmpdev.restaurantmanager.exception;

public class DishException extends CommonException {
    public static final String ERROR_NOT_FOUND = "Dish not found";
    public DishException(String message) {
        super(message);
    }
}