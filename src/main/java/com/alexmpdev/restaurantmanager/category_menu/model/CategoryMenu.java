package com.alexmpdev.restaurantmanager.category_menu.model;

import com.alexmpdev.restaurantmanager.dishes.model.Dish;
import com.alexmpdev.restaurantmanager.menu.model.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table( name = "category_menu")
public class CategoryMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name="menu_id", insertable = false, updatable = false)
    @JsonIgnore
    private Menu menu;

    @Column(name = "menu_id")
    private long menuId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "category_menu_dish",
            joinColumns = @JoinColumn(name = "category_menu_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id")
    )
    private List<Dish> dishes;

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
