package com.alexmpdev.restaurantmanager.menu.controller;

import com.alexmpdev.restaurantmanager.menu.model.Menu;
import com.alexmpdev.restaurantmanager.menu.service.MenuService;
import com.alexmpdev.restaurantmanager.restaurants.service.RestaurantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
@Tag(name = "MenuController" , description = "Tratamiento de los datos del menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {

        this.menuService = menuService;
    }

    @GetMapping
    public List<Menu> getAllMenu(){

        return menuService.getAllMenu();

    }

    @GetMapping("/{id}")
    public Menu getMenu(@PathVariable("id")Long id){
        return menuService.getMenu(id);
    }

    @PostMapping
    public void save(@RequestBody Menu menu){
        menuService.save(menu);
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable("id")Long id) {
        menuService.delete(id);
    };

    @PutMapping("/{id}")
    public void update(@PathVariable("id")Long id, @RequestBody Menu menu){
        menuService.update(id, menu);
    }

}
