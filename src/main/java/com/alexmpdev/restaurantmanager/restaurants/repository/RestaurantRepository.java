package com.alexmpdev.restaurantmanager.restaurants.repository;

import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository <Restaurant, Long> {

    List<Restaurant> findByCategoryId(int categoryId);
}
