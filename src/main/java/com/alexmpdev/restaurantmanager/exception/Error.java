package com.alexmpdev.restaurantmanager.exception;

import java.time.LocalDateTime;

public class Error {
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();

    public Error(String message){
        this.message = message;
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
}
