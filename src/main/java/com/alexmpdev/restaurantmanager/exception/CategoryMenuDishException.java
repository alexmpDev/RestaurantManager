package com.alexmpdev.restaurantmanager.exception;

public class CategoryMenuDishException extends CommonException{

    public static final String ERROR_NOT_FOUND = "CategoryMenuDish not found";
    public CategoryMenuDishException(String message) {

        super(message);
    }
}
