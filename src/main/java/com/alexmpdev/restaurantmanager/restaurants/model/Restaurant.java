package com.alexmpdev.restaurantmanager.restaurants.model;

import jakarta.persistence.*;
import java.io.File;
import java.time.LocalDate;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private int categoryId;
    private String title;
    private File Photo;
    private String Description;
    private LocalDate createdAt;

    public Long getId() {
        return Id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getPhoto() {
        return Photo;
    }

    public void setPhoto(File photo) {
        Photo = photo;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

}
