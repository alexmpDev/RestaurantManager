package com.alexmpdev.restaurantmanager.exception;

public abstract class CommonException extends RuntimeException {

    public CommonException(String message){
        super(message);
    }
}