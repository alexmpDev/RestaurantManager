package com.alexmpdev.restaurantmanager.restaurants.service.impl;

import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;
import com.alexmpdev.restaurantmanager.restaurants.repository.RestaurantRepository;
import com.alexmpdev.restaurantmanager.restaurants.service.RestaurantService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() { return this.restaurantRepository.findAll(); }

    public Restaurant getRestaurant(Long id) {

        return this.restaurantRepository.findById(id).orElse(null);
    }

    public void save(Restaurant restaurant) {
        this.restaurantRepository.save(restaurant);
    }

    public String update(Long id, Restaurant restaurant) throws BadRequestException {

        Restaurant editableRestaurant = getRestaurant(id);
        if (editableRestaurant == null){
            throw new BadRequestException("El restaurante no existe");
        }
        editableRestaurant.setCategoryId(restaurant.getCategoryId());
        editableRestaurant.setTitle(restaurant.getTitle());
        if (restaurant.getPhoto() != null) {
            editableRestaurant.setPhoto(restaurant.getPhoto());
        }
        editableRestaurant.setDescription(restaurant.getDescription());
        this.restaurantRepository.save(editableRestaurant);

        return "Has editado el restaurante con id: " + id;
    }

    public String delete(Long id) {

        Restaurant restaurant = getRestaurant(id);
        this.restaurantRepository.delete(restaurant);

        return "Has eliminado el restaurante con exito";
    }
}
