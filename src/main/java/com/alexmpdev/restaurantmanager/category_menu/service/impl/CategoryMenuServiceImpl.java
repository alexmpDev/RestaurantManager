package com.alexmpdev.restaurantmanager.category_menu.service.impl;

import com.alexmpdev.restaurantmanager.category_menu.model.CategoryMenu;
import com.alexmpdev.restaurantmanager.category_menu.repository.CategoryMenuRepository;
import com.alexmpdev.restaurantmanager.category_menu.service.CategoryMenuService;
import com.alexmpdev.restaurantmanager.exception.CategoryMenuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryMenuServiceImpl implements CategoryMenuService {

    private final CategoryMenuRepository categoryMenuRepository;

    @Autowired
    public CategoryMenuServiceImpl(CategoryMenuRepository categoryMenuRepository) { this.categoryMenuRepository = categoryMenuRepository; }

    @Override
    public List<CategoryMenu> getAllCategoriesMenu() {
        return categoryMenuRepository.findAll();
    }

    @Override
    public void save(CategoryMenu categoryMenu) {
        categoryMenuRepository.save(categoryMenu);
    }

    public CategoryMenu getCategoryMenu(Long id) {
        return categoryMenuRepository.findById(id)
                .orElseThrow(() -> new CategoryMenuException(CategoryMenuException.ERROR_NOT_FOUND));
    }

    @Override
    public void update(Long id, CategoryMenu categoryMenu) {

        CategoryMenu editableCategoryMenu = getCategoryMenu(id);
        editableCategoryMenu.setTitle(categoryMenu.getTitle());
        editableCategoryMenu.setMenu(categoryMenu.getMenu());
        categoryMenuRepository.save(editableCategoryMenu);
    }

    @Override
    public void delete(Long id) {

        CategoryMenu deleteCategoryMenu = getCategoryMenu(id);

        categoryMenuRepository.delete(deleteCategoryMenu);
    }
}
