package com.alexmpdev.restaurantmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class RestaurantManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantManagerApplication.class, args);
    }

}
