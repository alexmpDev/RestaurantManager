package com.alexmpdev.restaurantmanager.categories.service.Impl;

import com.alexmpdev.restaurantmanager.categories.model.Category;
import com.alexmpdev.restaurantmanager.categories.repository.CategoryRepository;
import com.alexmpdev.restaurantmanager.categories.service.CategoryService;
import com.alexmpdev.restaurantmanager.exception.CategoryNotFoundException;
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

        return this.categoryRepository.findById(id).orElse(null);
    }
    public void save(Category category) {

        this.categoryRepository.save(category);
    }
    public void update(Long id, Category category) throws BadRequestException {

        Category editableCategory = getCategory(id);
        if (editableCategory == null){
            throw new CategoryNotFoundException("La categoria no existe");
        }
        editableCategory.setName(category.getName());
        this.categoryRepository.save(editableCategory);
    }
    public void delete(Long id) {

        this.categoryRepository.deleteById(id);
    }
}
