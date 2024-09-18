package com.alexmpdev.restaurantmanager.dishes.service;

import com.alexmpdev.restaurantmanager.dishes.model.Dish;
import java.util.List;

public interface DishService {

    List<Dish> getAllDishes();
    Dish getDish(Long id);
    void save(Dish dish);
    String update(Long id, Dish dish);
    String delete(Long id);
}
