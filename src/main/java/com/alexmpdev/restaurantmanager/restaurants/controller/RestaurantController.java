package com.alexmpdev.restaurantmanager.restaurants.controller;

import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;
import com.alexmpdev.restaurantmanager.restaurants.service.RestaurantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
@Tag(name = "RestaurantController" , description = "Tratamiento de los datos del restaurante")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {

        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable("id") Long id){

        return restaurantService.getRestaurant(id);
    }

    @PostMapping()
    public String save(@RequestBody Restaurant restaurant){

        return restaurantService.save(restaurant);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody Restaurant restaurant) {

        return restaurantService.update(id, restaurant);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {

        return  restaurantService.delete(id);
    }
}
