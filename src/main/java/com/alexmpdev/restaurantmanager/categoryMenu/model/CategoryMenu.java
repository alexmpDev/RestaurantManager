package com.alexmpdev.restaurantmanager.categoryMenu.model;

import jakarta.persistence.*;

@Entity
@Table( name = "categoryMenu")
public class CategoryMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int menuId;
    private String title;

    public Long getId() {
        return id;
    }
    public int getMenuId() {return menuId;}
    public void setMenuId(int menuId) {this.menuId = menuId;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
}
