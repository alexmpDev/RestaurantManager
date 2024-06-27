package com.alexmpdev.restaurantmanager.exception;

public class CategoryException extends CommonException {
    public static final String ERROR_NOT_FOUND = "Category not found";
    public CategoryException(String message) {

        super(message);
    }
}
