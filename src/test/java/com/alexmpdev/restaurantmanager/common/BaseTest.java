package com.alexmpdev.restaurantmanager.common;

import com.alexmpdev.restaurantmanager.categories.model.Category;
import com.alexmpdev.restaurantmanager.category_menu.model.CategoryMenu;
import com.alexmpdev.restaurantmanager.dishes.model.Dish;
import com.alexmpdev.restaurantmanager.menu.model.Menu;
import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;

import java.time.LocalDate;

public class BaseTest {
        public Restaurant getRestaurant(Integer categoryId){
            return Restaurant.builder()
                    .categoryId(categoryId == null ? 1: categoryId)
                    .title("Pollos Hermanos")
                    .description("Es un test del guardado")
                    .photo("path/to/photo.jpg")
                    .createdAt(LocalDate.now())
                    .build();
        }

        public Dish getDish(){
            return Dish.builder()
                    .title("Tortilla de patata")
                    .description("Es un test del guardado")
                    .price(5)
                    .build();
        }

        public Menu getMenu(Integer restaurantId){
            return Menu.builder()
                    .restaurantId(restaurantId == null ? 1 : restaurantId)
                    .title("Menu del dia")
                    .price(15)
                    .build();
        }

        public Category getCategory(String name){

            return Category.builder()
                    .name(name == null ? "Restaurante" : name)
                    .build();
        };

        public CategoryMenu getCategoryMenu(String title, Integer menuId){

            return CategoryMenu.builder()
                    .title(title == null ? "Primer Plato" : title)
                    .menuId(menuId == null ? 1 : menuId)
                    .build();
        }
}
