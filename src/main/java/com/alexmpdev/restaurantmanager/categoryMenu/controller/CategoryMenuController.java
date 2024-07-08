package com.alexmpdev.restaurantmanager.categoryMenu.controller;

import com.alexmpdev.restaurantmanager.categoryMenu.model.CategoryMenu;
import com.alexmpdev.restaurantmanager.categoryMenu.service.CategoryMenuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoryMenu")
@Tag(name = "CategoryMenuController" , description = "Tratamiento de los datos de las categorias de los menus")

public class CategoryMenuController {

    private final CategoryMenuService categoryMenuService;

    public CategoryMenuController(CategoryMenuService categoryMenuService) { this.categoryMenuService = categoryMenuService; }

    @GetMapping
    public List<CategoryMenu> getAllCategoryMenu() {

        return categoryMenuService.getAllCategoriesMenu();
    }

    @PostMapping
    public void save(@RequestBody CategoryMenu categoryMenu ) {

        categoryMenuService.save(categoryMenu);
    }

    @GetMapping("/{id}")
    public CategoryMenu getCategoryMenu(@PathVariable("id")Long id){

        return categoryMenuService.getCategoryMenu(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id")Long id, @RequestBody CategoryMenu categoryMenu) {

        categoryMenuService.update(id, categoryMenu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id) {

        categoryMenuService.delete(id);
    }
}
