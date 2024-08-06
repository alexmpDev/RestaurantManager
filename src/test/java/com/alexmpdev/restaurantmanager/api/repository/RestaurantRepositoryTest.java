package com.alexmpdev.restaurantmanager.api.repository;

import com.alexmpdev.restaurantmanager.common.BaseTest;
import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;
import com.alexmpdev.restaurantmanager.restaurants.repository.RestaurantRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("test")
public class RestaurantRepositoryTest extends BaseTest {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @BeforeEach
    public void setUp(){
        restaurantRepository.deleteAll();
    }

    @Test
    public void RestaurantRepository_Save_ReturnSavedRestaurant(){

        //Arrange
        Restaurant restaurant = getRestaurant(1);

        //Act
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        //Assert
        Assertions.assertThat(savedRestaurant).isNotNull();
        Assertions.assertThat(savedRestaurant.getId()).isGreaterThan(0);
    }

    @Test
    public void RestaurantRepository_Update_ReturnUpdatedRestaurant(){

        //Arrange
        Restaurant restaurant = getRestaurant(1);

        //Act
        restaurantRepository.save(restaurant);
        Restaurant restaurantSave = restaurantRepository.findById(restaurant.getId()).get();
        restaurantSave.setTitle("PollosLocos");
        restaurantSave.setDescription("Es un test de update");

        Restaurant updatedRestaurant = restaurantRepository.save(restaurantSave);
        //Assert
        Assertions.assertThat(updatedRestaurant.getTitle()).isNotNull().isEqualTo("PollosLocos");
        Assertions.assertThat(updatedRestaurant.getDescription()).isNotNull().isEqualTo("Es un test de update");
    }

    @Test
    public void RestaurantRepository_Delete_ReturnRestaurantIsEmpty(){

        //Arrange
        Restaurant restaurant = getRestaurant(1);

        //Act
        restaurantRepository.save(restaurant);
        restaurantRepository.deleteById(restaurant.getId());
        Optional<Restaurant> restaurantReturn = restaurantRepository.findById(restaurant.getId());

        //Assert
        Assertions.assertThat(restaurantReturn).isEmpty();
    }

    @Test
    public void RestaurantRepository_findByCategoryId_ReturnTwoRestaurant(){

        //Arrange
        Restaurant restaurant = getRestaurant(2);

        Restaurant restaurant2 = getRestaurant(2);

        //Act
        restaurantRepository.save(restaurant);
        restaurantRepository.save(restaurant2);

        List<Restaurant> restaurantList = restaurantRepository.findByCategoryId(2);

        //Assert
        Assertions.assertThat(restaurantList).isNotNull();
        Assertions.assertThat(restaurantList.size()).isEqualTo(2);
    }
}
