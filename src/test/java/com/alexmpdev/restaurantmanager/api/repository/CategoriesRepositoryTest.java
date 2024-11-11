package com.alexmpdev.restaurantmanager.api.repository;

import com.alexmpdev.restaurantmanager.RestaurantManagerApplication;
import com.alexmpdev.restaurantmanager.categories.model.Category;
import com.alexmpdev.restaurantmanager.categories.repository.CategoryRepository;
import com.alexmpdev.restaurantmanager.common.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

@SpringBootTest(classes = RestaurantManagerApplication.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CategoriesRepositoryTest extends BaseTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void CategoriesRepository_Save_ReturnSavedCategory(){
        //Arrange
        Category category = getCategory("Restaurante");

        //Act
        Category savedCategory = categoryRepository.save(category);

        //Assert
        Assertions.assertThat(savedCategory).isNotNull();
        Assertions.assertThat(savedCategory.getId()).isPositive();

    }

    @Test
    void CategoriesRepository_Update_ReturnUpdatedCategory(){
        //Arrange
        Category category = getCategory("Restaurante");

        //Act
        Category savedCategory = categoryRepository.save(category);
        savedCategory.setName("Bar");

        Category updatedCategory = categoryRepository.save(savedCategory);

        //Assert
        Assertions.assertThat(updatedCategory.getName()).isNotNull().isEqualTo("Bar");

    }

    @Test
    void CategoriesRepository_Delete_ReturnCategoryIsEmpty(){
        //Arrange
        Category category = getCategory("Restaurante");

        //Act
        categoryRepository.save(category);
        categoryRepository.deleteById(category.getId());

        Optional<Category> categoryReturn = categoryRepository.findById(category.getId());

        //Assert
        Assertions.assertThat(categoryReturn).isEmpty();

    }
}
