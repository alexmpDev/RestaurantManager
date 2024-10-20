package com.alexmpdev.restaurantmanager.restaurants.service;

import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;
import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants(Integer category, String name);
    Restaurant getRestaurant(Long id);
    void save(Restaurant restaurant);
    String update(Long id, Restaurant restaurant);
    void delete(Long id);
    List<Restaurant> findByCategoryId(int categoryId);
}
