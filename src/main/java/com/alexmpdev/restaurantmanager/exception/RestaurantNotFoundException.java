package com.alexmpdev.restaurantmanager.exception;

public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
