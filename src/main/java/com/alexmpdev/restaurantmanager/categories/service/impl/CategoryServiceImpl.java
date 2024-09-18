package com.alexmpdev.restaurantmanager.categories.service.impl;

import com.alexmpdev.restaurantmanager.categories.model.Category;
import com.alexmpdev.restaurantmanager.categories.repository.CategoryRepository;
import com.alexmpdev.restaurantmanager.categories.service.CategoryService;
import com.alexmpdev.restaurantmanager.exception.CategoryException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories() {

        return this.categoryRepository.findAll();
    }
    public Category getCategory(Long id) {

        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryException(CategoryException.ERROR_NOT_FOUND));
    }
    public void save(Category category) {

        this.categoryRepository.save(category);
    }
    public void update(Long id, Category category) throws BadRequestException {

        Category editableCategory = getCategory(id);
        if (editableCategory == null){
            throw new CategoryException("La categoria no existe");
        }
        editableCategory.setName(category.getName());
        this.categoryRepository.save(editableCategory);
    }
    public void delete(Long id) {

        Category deleteCategory = getCategory(id);
        if (deleteCategory == null){
            throw new CategoryException("La categoria no existe");
        }
        this.categoryRepository.deleteById(id);
    }
}
