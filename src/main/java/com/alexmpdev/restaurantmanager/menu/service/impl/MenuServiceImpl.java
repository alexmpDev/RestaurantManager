package com.alexmpdev.restaurantmanager.menu.service.impl;

import com.alexmpdev.restaurantmanager.exception.MenuException;
import com.alexmpdev.restaurantmanager.exception.RestaurantException;
import com.alexmpdev.restaurantmanager.menu.model.Menu;
import com.alexmpdev.restaurantmanager.menu.repository.MenuRepository;
import com.alexmpdev.restaurantmanager.menu.service.MenuService;
import com.alexmpdev.restaurantmanager.restaurants.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getAllMenu() {
        return this.menuRepository.findAll();
    }

    public Menu getMenu(Long id) {
        return this.menuRepository.findById(id)
                .orElseThrow(() -> new MenuException(MenuException.ERROR_NOT_FOUND));
    }

    public void save(Menu menu) {

        this.menuRepository.save(menu);
    }

    public void delete(Long id) {
        this.menuRepository.deleteById(id);
    }

    public void update(Long id, Menu menu) {

        Menu editableMenu = getMenu(id);
        editableMenu.setRestaurantId(menu.getRestaurantId());
        editableMenu.setPrice(menu.getPrice());
        editableMenu.setTitle(menu.getTitle());

        this.menuRepository.save(editableMenu);
    }
}
