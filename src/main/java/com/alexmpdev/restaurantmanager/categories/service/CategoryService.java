package com.alexmpdev.restaurantmanager.categories.service;

import com.alexmpdev.restaurantmanager.categories.model.Category;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface CategoryService  {

    List<Category> getAllCategories();
    Category getCategory(Long id);
    void save(Category category);
    void update(Long id, Category category) throws BadRequestException;
    void delete(Long id);
}
