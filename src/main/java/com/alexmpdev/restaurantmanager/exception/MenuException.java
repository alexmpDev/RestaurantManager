package com.alexmpdev.restaurantmanager.exception;

public class MenuException extends CommonException{
    public static final String ERROR_NOT_FOUND = "Menu not found";
    public MenuException(String message) {
        super(message);
    }

}
