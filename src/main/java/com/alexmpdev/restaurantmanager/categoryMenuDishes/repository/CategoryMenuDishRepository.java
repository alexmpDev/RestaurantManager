package com.alexmpdev.restaurantmanager.categoryMenuDishes.repository;

import com.alexmpdev.restaurantmanager.categoryMenuDishes.model.CategoryMenuDish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMenuDishRepository extends JpaRepository<CategoryMenuDish, Long> {
}
