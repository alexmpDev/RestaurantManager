package com.alexmpdev.restaurantmanager.api.service;

import com.alexmpdev.restaurantmanager.common.BaseTest;
import com.alexmpdev.restaurantmanager.menu.model.Menu;
import com.alexmpdev.restaurantmanager.menu.repository.MenuRepository;
import com.alexmpdev.restaurantmanager.menu.service.impl.MenuServiceImpl;
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
public class MenuServiceTest extends BaseTest {

    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private MenuServiceImpl menuService;

    @Test
    void MenuServive_Save_return200(){

        int id = 1;

        Menu menu = getMenu(id);

        menuService.save(menu);

        verify(menuRepository,atLeastOnce()).save(menu);
    }

    @Test
    void MenuService_getMenu_returnMenu(){

        Long menuId = 1L;

        Menu expectedMenu = getMenu(1);

        when(menuRepository.findById(menuId)).thenReturn(Optional.of(expectedMenu));

        Menu actualMenu = menuService.getMenu(menuId);

        verify(menuRepository, atLeastOnce()).findById(menuId);
        Assertions.assertEquals(actualMenu,expectedMenu);
    }

    @Test
    void MenuService_GetAllMenu_returnList(){

        List<Menu> expectedMenu = List.of(getMenu(1));
        when(menuRepository.findAll()).thenReturn(expectedMenu);

        List<Menu> actualMenu = menuService.getAllMenu();

        verify(menuRepository,atLeastOnce()).findAll();

        Assertions.assertEquals(expectedMenu, actualMenu);
    }

    @Test
    void MenuService_delete_returnStatus200(){

        Menu menu = getMenu(1);

        menuService.delete(1L);

        verify(menuRepository, atLeastOnce()).deleteById(1L);
    }

}
