package com.alexmpdev.restaurantmanager.restaurants.service.impl;

import com.alexmpdev.restaurantmanager.exception.DishException;
import com.alexmpdev.restaurantmanager.exception.RestaurantException;
import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;
import com.alexmpdev.restaurantmanager.restaurants.repository.RestaurantRepository;
import com.alexmpdev.restaurantmanager.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants(Integer category, String name) {
        List<Restaurant> restaurants =  this.restaurantRepository.findAll();

        if (category != null){
            restaurants = restaurants
                    .stream()
                    .filter(restaurant ->  category == restaurant.getCategoryId())
                    .collect(Collectors.toList());
        }

        if (name != null){
            restaurants = restaurants
                    .stream()
                    .filter(restaurant ->  restaurant.getTitle().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return restaurants;
    }

    public Restaurant getRestaurant(Long id) {

        return this.restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantException(RestaurantException.ERROR_NOT_FOUND));
    }

    public void save(Restaurant restaurant) {
        this.restaurantRepository.save(restaurant);
    }

    public String update(Long id, Restaurant restaurant){

        Restaurant editableRestaurant = getRestaurant(id);
        editableRestaurant.setCategoryId(restaurant.getCategoryId());
        editableRestaurant.setTitle(restaurant.getTitle());
        if (restaurant.getPhoto() != null) {
            editableRestaurant.setPhoto(restaurant.getPhoto());
        }
        editableRestaurant.setDescription(restaurant.getDescription());
        this.restaurantRepository.save(editableRestaurant);

        return "Has editado el restaurante con id: " + id;
    }

    public void delete(Long id) {

        Restaurant restaurant = getRestaurant(id);
        if (restaurant == null){
            throw new RestaurantException("El restaurante no existe");
        }

        this.restaurantRepository.delete(restaurant);

    }

    public List<Restaurant> findByCategoryId(int categoryId) {

        return this.restaurantRepository.findByCategoryId(categoryId);
    }
}
