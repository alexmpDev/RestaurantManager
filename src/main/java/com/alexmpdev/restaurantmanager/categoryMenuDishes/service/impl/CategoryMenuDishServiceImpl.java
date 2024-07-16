package com.alexmpdev.restaurantmanager.categoryMenuDishes.service.impl;

import com.alexmpdev.restaurantmanager.categoryMenu.model.CategoryMenu;
import com.alexmpdev.restaurantmanager.categoryMenuDishes.model.CategoryMenuDish;
import com.alexmpdev.restaurantmanager.categoryMenuDishes.repository.CategoryMenuDishRepository;
import com.alexmpdev.restaurantmanager.categoryMenuDishes.service.CategoryMenuDishService;
import com.alexmpdev.restaurantmanager.exception.CategoryMenuDishException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryMenuDishServiceImpl implements CategoryMenuDishService {

    private final CategoryMenuDishRepository categoryMenuDishRepository;

    public CategoryMenuDishServiceImpl(CategoryMenuDishRepository categoryMenuDishRepository) {
        this.categoryMenuDishRepository = categoryMenuDishRepository;
    }

    @Override
    public List<CategoryMenuDish> getAllCategoryMenuDish() {
        return this.categoryMenuDishRepository.findAll();
    }

    @Override
    public CategoryMenuDish getCategoryMenuDish(Long id) {
        return this.categoryMenuDishRepository.findById(id)
                .orElseThrow(() -> new CategoryMenuDishException(CategoryMenuDishException.ERROR_NOT_FOUND));
    }

    @Override
    public void save(CategoryMenuDish categoryMenuDish) {
        this.categoryMenuDishRepository.save(categoryMenuDish);
    }

    @Override
    public void update(CategoryMenuDish categoryMenuDish, Long id) {
        CategoryMenuDish editableCategoryMenuDish = getCategoryMenuDish(id);
        editableCategoryMenuDish.setDishId(categoryMenuDish.getDishId());
        editableCategoryMenuDish.setMenuCategoryId(categoryMenuDish.getMenuCategoryId());
        categoryMenuDishRepository.save(editableCategoryMenuDish);
    }

    @Override
    public void delete(Long id) {
        CategoryMenuDish deleteCategoryMenuDish = getCategoryMenuDish(id);
        this.categoryMenuDishRepository.delete(deleteCategoryMenuDish);
    }
}
