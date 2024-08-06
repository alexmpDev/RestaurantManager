package com.alexmpdev.restaurantmanager.dishes.model;

import com.alexmpdev.restaurantmanager.category_menu.model.CategoryMenu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String description;
    private float price;

    @ManyToMany(mappedBy = "dishes")
    @JsonIgnore
    private List<CategoryMenu> categoriesMenu;

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<CategoryMenu> getCategoriesMenu() {
        return categoriesMenu;
    }

    public void setCategoriesMenu(List<CategoryMenu> categoriesMenu) {
        this.categoriesMenu = categoriesMenu;
    }
}
