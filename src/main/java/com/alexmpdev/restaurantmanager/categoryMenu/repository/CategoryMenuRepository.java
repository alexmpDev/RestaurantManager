package com.alexmpdev.restaurantmanager.categoryMenu.repository;

import com.alexmpdev.restaurantmanager.categoryMenu.model.CategoryMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMenuRepository extends JpaRepository<CategoryMenu, Long> {
}
