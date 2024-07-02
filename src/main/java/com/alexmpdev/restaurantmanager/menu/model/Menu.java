package com.alexmpdev.restaurantmanager.menu.model;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int restaurantId;
    private String title;
    private float price;

    public Long getId() {return id;}
    public int getRestaurantId() {return restaurantId;}
    public void setRestaurantId(int restaurantId) {this.restaurantId = restaurantId;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public float getPrice() {return price;}
    public void setPrice(float price) {this.price = price;}
}
