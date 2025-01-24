package com.alexmpdev.restaurantmanager.api.service;

import com.alexmpdev.restaurantmanager.categories.model.Category;
import com.alexmpdev.restaurantmanager.category_menu.model.CategoryMenu;
import com.alexmpdev.restaurantmanager.category_menu.repository.CategoryMenuRepository;
import com.alexmpdev.restaurantmanager.category_menu.service.impl.CategoryMenuServiceImpl;
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
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class CategoryMenuServiceTest extends BaseTest {

    @Mock
    private CategoryMenuRepository categoryMenuRepository;

    @InjectMocks
    private CategoryMenuServiceImpl categoryMenuService;

    @Test
    void CategoryMenuService_Save_returnStatus200() {

        CategoryMenu categoryMenu = getCategoryMenu("Juan", 1);

        categoryMenuService.save(categoryMenu);

        verify(categoryMenuRepository).save(categoryMenu);

    }

    @Test
    void CategoryMenuService_GetCategoryMenu_returnCategoryMenu(){

        Long categoryMenuId = 1L;
        CategoryMenu expectedCategoryMenu = getCategoryMenu("Prueba", 1);

        when(categoryMenuRepository.findById(categoryMenuId)).thenReturn(Optional.of(expectedCategoryMenu));

        CategoryMenu actualCategoryMenu = categoryMenuService.getCategoryMenu(categoryMenuId);

        verify(categoryMenuRepository, atLeastOnce()).findById(categoryMenuId);
        Assertions.assertEquals(expectedCategoryMenu, actualCategoryMenu);
    }

    @Test
    void CategoryMenuService_GetAllCategoriesMenu_returnList(){

        List<CategoryMenu> expectedCategoriesMenu = List.of(getCategoryMenu("Prueba", 1));
        when(categoryMenuRepository.findAll()).thenReturn(expectedCategoriesMenu);

        List<CategoryMenu> actualCategoriesMenu = categoryMenuService.getAllCategoriesMenu();

        verify(categoryMenuRepository,atLeastOnce()).findAll();

        Assertions.assertEquals(expectedCategoriesMenu, actualCategoriesMenu);
    }

    @Test
    void CategoryMenuService_delete_returnStatus200(){

        CategoryMenu categoryMenu = getCategoryMenu("Juan", 1);

        when(categoryMenuRepository.findById(1L)).thenReturn(Optional.of(categoryMenu));

        categoryMenuService.delete(1L);

        verify(categoryMenuRepository, atLeastOnce()).delete(categoryMenu);

    }

}
