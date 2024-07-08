package com.alexmpdev.restaurantmanager.categoryMenu.service;

import com.alexmpdev.restaurantmanager.categoryMenu.model.CategoryMenu;

import java.util.List;

public interface CategoryMenuService {

    public List<CategoryMenu> getAllCategoriesMenu();
    public void save(CategoryMenu categoryMenu);
    public CategoryMenu getCategoryMenu(Long id);
    public void update(Long id, CategoryMenu categoryMenu);
    public void delete(Long id);
}
