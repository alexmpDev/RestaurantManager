package com.alexmpdev.restaurantmanager.dishes.service.impl;

import com.alexmpdev.restaurantmanager.dishes.model.Dish;
import com.alexmpdev.restaurantmanager.dishes.repository.DishRepository;
import com.alexmpdev.restaurantmanager.dishes.service.DishService;
import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;
import com.alexmpdev.restaurantmanager.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Autowired
    public DishServiceImpl( DishRepository dishRepository ){

        this.dishRepository = dishRepository;
    }

    public List<Dish> getAllDishes(  ){

        return this.dishRepository.findAll();
    }

    public Dish getDish( Long id ) {

        return this.dishRepository.findById(id).orElse(null);
    }

    public String save( Dish dish ) {

        this.dishRepository.save(dish);

        return "Has guardado un plato con exito";
    }

    public String update( Long id, Dish dish ) {

        Dish editableDish = getDish(id);
        editableDish.setTitle(dish.getTitle());
        editableDish.setDescription(dish.getDescription());
        editableDish.setPrice(dish.getPrice());
        this.dishRepository.save(editableDish);

        return "Has editado el plato con id: " + id;
    }

    public String delete( Long id ) {

        Dish deleteDih = getDish(id);
        this.dishRepository.delete(deleteDih);

        return "Has eliminado el plato";
    }

}
