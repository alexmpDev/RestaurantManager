package com.alexmpdev.restaurantmanager.api.service;

import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;
import com.alexmpdev.restaurantmanager.common.BaseTest;
import com.alexmpdev.restaurantmanager.restaurants.repository.RestaurantRepository;
import com.alexmpdev.restaurantmanager.restaurants.service.impl.RestaurantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest extends BaseTest {
    
    @Mock
    RestaurantRepository restaurantRepository;
            
    @InjectMocks
    RestaurantServiceImpl restaurantService;

    @Test
    void RestaurantService_Save_returnStatus200() {

        Restaurant restaurant = getRestaurant(1);

        restaurantService.save(restaurant);

        verify(restaurantRepository).save(restaurant);

    }

    @Test
    void RestaurantService_GetRestaurant_returnRestaurant(){

        Long restaurantId = 1L;
        Restaurant expectedRestaurant = getRestaurant(1);

        when(restaurantRepository.findById(restaurantId)).thenReturn(Optional.of(expectedRestaurant));

        Restaurant actualRestaurant = restaurantService.getRestaurant(restaurantId);

        verify(restaurantRepository, atLeastOnce()).findById(restaurantId);
        Assertions.assertEquals(expectedRestaurant, actualRestaurant);
    }

    @Test
    void RestaurantService_GetAllCategories_returnList(){

        List<Restaurant> expectedRestaurants = List.of(getRestaurant(1));
        when(restaurantRepository.findAll()).thenReturn(expectedRestaurants);

        List<Restaurant> actualRestaurants = restaurantService.getAllRestaurants(null, null);

        verify(restaurantRepository,atLeastOnce()).findAll();

        Assertions.assertEquals(expectedRestaurants, actualRestaurants);
    }

    @Test
    void RestaurantService_delete_returnStatus200(){

        Restaurant restaurant = getRestaurant( 1);

        when(restaurantRepository.findById(1L)).thenReturn(Optional.of(restaurant));

        restaurantService.delete(1L);

        verify(restaurantRepository, atLeastOnce()).delete(restaurant);

    }
}
