package com.alexmpdev.restaurantmanager.api.service;

import com.alexmpdev.restaurantmanager.categories.model.Category;
import com.alexmpdev.restaurantmanager.categories.repository.CategoryRepository;
import com.alexmpdev.restaurantmanager.categories.service.impl.CategoryServiceImpl;
import com.alexmpdev.restaurantmanager.common.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoriesServiceTest extends BaseTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void CategoryService_Save_returnStatus200() {

        Category category = getCategory("Juan");

        categoryService.save(category);

        verify(categoryRepository).save(category);

    }

    @Test
    void CategoryService_GetCategory_returnCategory(){

        Long categoryId = 1L;
        Category expectedCategory = getCategory("Prueba");

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(expectedCategory));

        Category actualCategory = categoryService.getCategory(categoryId);

        verify(categoryRepository, atLeastOnce()).findById(categoryId);
        Assertions.assertEquals(expectedCategory, actualCategory);
    }

    @Test
    void CategoryService_GetAllCategories_returnList(){

        List<Category> expectedCategories = List.of(getCategory("Prueba"));
        when(categoryRepository.findAll()).thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.getAllCategories();

        verify(categoryRepository,atLeastOnce()).findAll();

        Assertions.assertEquals(expectedCategories, actualCategories);
    }

    @Test
    void CategoryService_delete_returnStatus200(){

        Category category = getCategory("Prueba");

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        categoryService.delete(1L);

        verify(categoryRepository, atLeastOnce()).deleteById(1L);

    }
}
