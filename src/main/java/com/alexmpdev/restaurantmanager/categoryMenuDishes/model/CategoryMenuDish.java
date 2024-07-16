package com.alexmpdev.restaurantmanager.categoryMenuDishes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoryMenuDish")
public class CategoryMenuDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int menuCategoryId;
    private int dishId;

    public Long getId() {
        return id;
    }

    public int getMenuCategoryId() {
        return menuCategoryId;
    }

    public void setMenuCategoryId(int menuCategoryId) {
        this.menuCategoryId = menuCategoryId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }
}
