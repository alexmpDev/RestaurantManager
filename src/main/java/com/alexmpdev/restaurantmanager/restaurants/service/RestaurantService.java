package com.alexmpdev.restaurantmanager.restaurants.service;

import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurant(Long id);
    void save(Restaurant restaurant);
    String update(Long id, Restaurant restaurant) throws BadRequestException;
    String delete(Long id);
}
