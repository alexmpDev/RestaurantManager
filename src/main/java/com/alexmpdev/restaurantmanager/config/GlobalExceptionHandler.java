package com.alexmpdev.restaurantmanager.config;

import com.alexmpdev.restaurantmanager.exception.CategoryNotFoundException;
import com.alexmpdev.restaurantmanager.exception.Error;
import com.alexmpdev.restaurantmanager.exception.RestaurantException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({RestaurantException.class, CategoryNotFoundException.class})
    public ResponseEntity<Error> handlerNotFoundException(RuntimeException e){
        Error error = new Error(e.getLocalizedMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
