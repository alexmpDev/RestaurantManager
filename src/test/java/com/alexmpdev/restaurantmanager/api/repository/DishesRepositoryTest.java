package com.alexmpdev.restaurantmanager.api.repository;

import com.alexmpdev.restaurantmanager.RestaurantManagerApplication;
import com.alexmpdev.restaurantmanager.common.BaseTest;
import com.alexmpdev.restaurantmanager.dishes.model.Dish;
import com.alexmpdev.restaurantmanager.dishes.repository.DishRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

@SpringBootTest(classes = RestaurantManagerApplication.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class DishesRepositoryTest extends BaseTest {

    @Autowired
    private DishRepository dishRepository;

    @Test
    public void DishRepository_Save_ReturnSavedDish(){

        //Arrange
        Dish dish = getDish();

        //Act
        Dish savedDish = dishRepository.save(dish);

        //Assert
        Assertions.assertThat(savedDish).isNotNull();
        Assertions.assertThat(savedDish.getId()).isGreaterThan(0);
    }

    @Test
    public void DishRepository_Update_ReturnUpdatedDish(){

        //Arrange
        Dish dish = getDish();

        //Act
        dishRepository.save(dish);
        Dish saveDish = dishRepository.findById(dish.getId()).get();
        saveDish.setTitle("Paella");
        saveDish.setDescription("Es un test de update");

        Dish updatedDish = dishRepository.save(saveDish);
        //Assert
        Assertions.assertThat(updatedDish.getTitle()).isNotNull().isEqualTo("Paella");
        Assertions.assertThat(updatedDish.getDescription()).isNotNull().isEqualTo("Es un test de update");
    }

    @Test
    public void DishRepository_Delete_ReturnDishIsEmpty(){

        //Arrange
        Dish dish = getDish();

        //Act
        dishRepository.save(dish);
        dishRepository.deleteById(dish.getId());
        Optional<Dish> dishReturn = dishRepository.findById(dish.getId());

        //Assert
        Assertions.assertThat(dishReturn).isEmpty();
    }
}
