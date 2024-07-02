package com.alexmpdev.restaurantmanager.menu.service;

import com.alexmpdev.restaurantmanager.menu.model.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getAllMenu();
    Menu getMenu(Long id);
    void save(Menu menu);
    void delete(Long id);
    void update(Long id, Menu menu);
}
