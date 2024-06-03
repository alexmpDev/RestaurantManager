package com.alexmpdev.restaurantmanager.categories.controller;

import com.alexmpdev.restaurantmanager.categories.model.Category;
import com.alexmpdev.restaurantmanager.categories.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@Tag(name = "CategoryController" , description = "Tratamiento de los datos de las categorias")

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){

        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {

        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id")Long id ){

        return categoryService.getCategory(id);
    }

    @PostMapping
    public void create(Category category) {

        categoryService.save(category);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id")Long id, Category category) throws BadRequestException {

        categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable("id")Long id ) {

        categoryService.delete(id);
    }
}
