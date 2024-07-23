package com.alexmpdev.restaurantmanager.menu.model;

import com.alexmpdev.restaurantmanager.category_menu.model.CategoryMenu;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menu_id")
    private Long id;
    private int restaurantId;
    private String title;
    private float price;
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private Set<CategoryMenu> categoriesMenu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<CategoryMenu> getCategoriesMenu() {
        return categoriesMenu;
    }

    public void setCategoriesMenu(Set<CategoryMenu> categoriesMenu) {
        this.categoriesMenu = categoriesMenu;
    }




}
