package com.alexmpdev.restaurantmanager.dishes.controller;

import com.alexmpdev.restaurantmanager.dishes.model.Dish;
import com.alexmpdev.restaurantmanager.dishes.service.DishService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/dishes")
@Tag(name = "DishController" , description = "Tratamiento de los datos de los platos")
public class DishController {

    private final DishService dishService;

    public DishController( DishService dishService ) {

        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> getAllDishes(  ) {

        return dishService.getAllDishes();
    }

    @GetMapping("/{id}")
    public Dish getDish( @PathVariable("id") Long id ){

        return dishService.getDish(id);
    }

    @PostMapping
    public String save( Dish dish ) {

        return dishService.save(dish);
    }

    @PutMapping("/{id}")
    public String update( @PathVariable("id")Long id, Dish dish ) {

        return dishService.update(id, dish);
    }

    @DeleteMapping("{id}")
    public String delete( @PathVariable("id")Long id ) {

        return  dishService.delete(id);
    }
}
