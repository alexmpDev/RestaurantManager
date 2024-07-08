package com.alexmpdev.restaurantmanager.exception;

public class CategoryMenuException extends CommonException{

    public static final String ERROR_NOT_FOUND = "CategoryMenu not found";
    public CategoryMenuException(String message) {

        super(message);
    }
}
