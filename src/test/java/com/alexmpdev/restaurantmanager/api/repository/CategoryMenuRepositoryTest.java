package com.alexmpdev.restaurantmanager.api.repository;

import com.alexmpdev.restaurantmanager.RestaurantManagerApplication;
import com.alexmpdev.restaurantmanager.category_menu.model.CategoryMenu;
import com.alexmpdev.restaurantmanager.category_menu.repository.CategoryMenuRepository;
import com.alexmpdev.restaurantmanager.common.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest(classes = RestaurantManagerApplication.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CategoryMenuRepositoryTest extends BaseTest {

    @Autowired
    private CategoryMenuRepository categoryMenuRepository;

    @Test
    void CategoryMenuRepository_Save_ReturnSavedCategoryMenu(){

        //Arrange
        CategoryMenu categoryMenu = getCategoryMenu("Primer Plato", 1);

        //Act
        CategoryMenu savedCategoryMenu = categoryMenuRepository.save(categoryMenu);

        //Assert
        Assertions.assertThat(savedCategoryMenu).isNotNull();
        Assertions.assertThat(savedCategoryMenu.getId()).isGreaterThan(0);
    }

    @Test
    void CategoryMenuRepository_Update_ReturnUpdatedCategoryMenu(){

        //Arrange
        CategoryMenu categoryMenu = getCategoryMenu("Primer Plato", 1);

        //Act
        CategoryMenu savedCategoryMenu = categoryMenuRepository.save(categoryMenu);
        savedCategoryMenu.setTitle("Segundo Plato");
        savedCategoryMenu.setMenuId(2);

        CategoryMenu updatedCategory = categoryMenuRepository.save(savedCategoryMenu);

        //Assert
        Assertions.assertThat(updatedCategory).isNotNull();
        Assertions.assertThat(updatedCategory.getTitle()).isNotNull().isEqualTo("Segundo Plato");
        Assertions.assertThat(updatedCategory.getMenuId()).isEqualTo(2);
    }

    @Test
    void CategoryMenuRepository_Delete_ReturnCategoryMenuIsEmpty(){

        //Arrange
        CategoryMenu categoryMenu = getCategoryMenu("Primer Plato", 1);

        //Act
        categoryMenuRepository.save(categoryMenu);
        categoryMenuRepository.deleteById(categoryMenu.getId());

        Optional<CategoryMenu> returnCategoryMenu = categoryMenuRepository.findById(categoryMenu.getId());


        //Assert
        Assertions.assertThat(returnCategoryMenu).isEmpty();
    }
}
