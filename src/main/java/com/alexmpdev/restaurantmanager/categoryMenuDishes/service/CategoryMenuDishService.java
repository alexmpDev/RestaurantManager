package com.alexmpdev.restaurantmanager.categoryMenuDishes.service;

import com.alexmpdev.restaurantmanager.categoryMenuDishes.model.CategoryMenuDish;

import java.util.List;

public interface CategoryMenuDishService {

    List<CategoryMenuDish> getAllCategoryMenuDish();
    CategoryMenuDish getCategoryMenuDish(Long id);
    void save(CategoryMenuDish categoryMenuDish);
    void update(CategoryMenuDish categoryMenuDish, Long id);
    void delete(Long id);
}
