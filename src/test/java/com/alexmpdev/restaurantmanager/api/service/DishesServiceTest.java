package com.alexmpdev.restaurantmanager.api.service;

import com.alexmpdev.restaurantmanager.common.BaseTest;
import com.alexmpdev.restaurantmanager.dishes.model.Dish;
import com.alexmpdev.restaurantmanager.dishes.repository.DishRepository;
import com.alexmpdev.restaurantmanager.dishes.service.impl.DishServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DishesServiceTest extends BaseTest {

    @Mock
    private DishRepository dishRepository;

    @InjectMocks
    private DishServiceImpl dishService;

    @Test
    void dishService_Save_returnStatus200() {

        Dish dish = getDish();

        dishService.save(dish);

        verify(dishRepository).save(dish);

    }

    @Test
    void dishService_getAllDishes_returnList() {

        List<Dish> expectedDishes = List.of(getDish());

        when(dishRepository.findAll()).thenReturn(expectedDishes);

        List<Dish> actualDishes = dishService.getAllDishes();

        verify(dishRepository, atLeastOnce()).findAll();

        Assertions.assertEquals(expectedDishes, actualDishes);
    }

    @Test
    void setDishService_getDish_returnDish() {

        Dish expectedDish = getDish();
        Long id = 1L;

        when(dishRepository.findById(id)).thenReturn(Optional.of(expectedDish));

        Dish actualDish = dishService.getDish(id);

        verify(dishRepository,atLeastOnce()).findById(id);

        Assertions.assertEquals(expectedDish, actualDish);
    }

    @Test
    void DishService_delete_returnStatus200(){

        Dish dish = getDish();

        when(dishRepository.findById(1L)).thenReturn(Optional.of(dish));

        dishService.delete(1L);

        verify(dishRepository, atLeastOnce()).delete(dish);
    }
}
