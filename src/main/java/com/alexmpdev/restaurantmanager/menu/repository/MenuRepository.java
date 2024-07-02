package com.alexmpdev.restaurantmanager.menu.repository;

import com.alexmpdev.restaurantmanager.menu.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository <Menu, Long> {
}
