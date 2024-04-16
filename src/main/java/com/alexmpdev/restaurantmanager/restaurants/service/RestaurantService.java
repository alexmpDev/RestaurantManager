package com.alexmpdev.restaurantmanager.restaurants.service;

import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;
import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurant(Long id);
    String save(Restaurant restaurant);
    String update(Long id, Restaurant restaurant);
    String delete(Long id);
}
