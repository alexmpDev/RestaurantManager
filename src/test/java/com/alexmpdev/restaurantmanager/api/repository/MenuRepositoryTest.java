package com.alexmpdev.restaurantmanager.api.repository;

import com.alexmpdev.restaurantmanager.RestaurantManagerApplication;
import com.alexmpdev.restaurantmanager.common.BaseTest;
import com.alexmpdev.restaurantmanager.menu.model.Menu;
import com.alexmpdev.restaurantmanager.menu.repository.MenuRepository;
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
class MenuRepositoryTest extends BaseTest {
    @Autowired
    private MenuRepository menuRepository;

    @Test
    void MenuRepository_Save_ReturnSavedMenu(){

        //Arrange
        Menu menu = getMenu(1);

        //Act
        Menu savedMenu = menuRepository.save(menu);

        //Assert
        Assertions.assertThat(savedMenu).isNotNull();
        Assertions.assertThat(savedMenu.getId()).isGreaterThan(0);
    }

    @Test
    void MenuRepository_Update_ReturnUpdatedMenu(){

        //Arrange
        Menu menu = getMenu(1);

        //Act
        menuRepository.save(menu);
        Menu saveMenu = menuRepository.findById(menu.getId()).get();
        saveMenu.setTitle("Menu de noche");
        saveMenu.setPrice(20);

        Menu updatedMenu = menuRepository.save(saveMenu);
        //Assert
        Assertions.assertThat(updatedMenu.getTitle()).isNotNull().isEqualTo("Menu de noche");
        Assertions.assertThat(updatedMenu.getPrice()).isNotNull().isEqualTo(20);

    }

    @Test
    void MenuRepository_Delete_ReturnMenuIsEmpty(){

        //Arrange
        Menu menu = getMenu(1);

        //Act
        menuRepository.save(menu);
        menuRepository.deleteById(menu.getId());
        Optional<Menu> menuReturn = menuRepository.findById(menu.getId());

        //Assert
        Assertions.assertThat(menuReturn).isEmpty();
    }
}
