package com.alexmpdev.restaurantmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

public class Error {
    private String message;

    private int code;
    private LocalDateTime timestamp = LocalDateTime.now();

    public Error(String message){
        this.message = message;
        this.code = HttpStatus.BAD_REQUEST.value();
    }
    public Error(String message, HttpStatusCode code){
        this.message = message;
        this.code = code.value();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
