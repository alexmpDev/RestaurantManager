package com.alexmpdev.restaurantmanager.exception;

public class RestaurantException extends CommonException {
    public static final String ERROR_NOT_FOUND = "Restaurant not found";
    public RestaurantException(String message) {
        super(message);
    }
}
