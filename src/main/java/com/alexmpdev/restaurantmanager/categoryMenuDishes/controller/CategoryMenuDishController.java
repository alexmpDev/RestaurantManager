package com.alexmpdev.restaurantmanager.categoryMenuDishes.controller;

import com.alexmpdev.restaurantmanager.categoryMenuDishes.model.CategoryMenuDish;
import com.alexmpdev.restaurantmanager.categoryMenuDishes.service.CategoryMenuDishService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoryMenuDish")
@Tag(name = "CategoryMenuDishController" , description = "Tratamiento de los datos de los platos junto a las categorias de los menus")

public class CategoryMenuDishController {

    private final CategoryMenuDishService categoryMenuDishService;

    public CategoryMenuDishController(CategoryMenuDishService categoryMenuDishService) {
        this.categoryMenuDishService = categoryMenuDishService;
    }

    @GetMapping
    public List<CategoryMenuDish> getAllCategoryMenuDish(){
        return this.categoryMenuDishService.getAllCategoryMenuDish();
    }

    @GetMapping("/{id}")
    public CategoryMenuDish getCategoryMenuDish(@PathVariable("id")Long id){
        return this.categoryMenuDishService.getCategoryMenuDish(id);
    }

    @PostMapping
    public void save(@RequestBody CategoryMenuDish categoryMenuDish){
        this.categoryMenuDishService.save(categoryMenuDish);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody CategoryMenuDish categoryMenuDish, @PathVariable("id")Long id){
        this.categoryMenuDishService.update(categoryMenuDish, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id){
        this.categoryMenuDishService.delete(id);
    }
}
