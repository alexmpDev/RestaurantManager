package com.alexmpdev.restaurantmanager.category_menu.repository;

import com.alexmpdev.restaurantmanager.category_menu.model.CategoryMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMenuRepository extends JpaRepository<CategoryMenu, Long> {
}
