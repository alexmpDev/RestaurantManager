package com.alexmpdev.restaurantmanager.exception;

public class RestaurantException extends RuntimeException {
    public static final String ERROR_NOT_FOUND = "Restaurant not found";
    public RestaurantException(String message) {

        super(message);
    }
}
