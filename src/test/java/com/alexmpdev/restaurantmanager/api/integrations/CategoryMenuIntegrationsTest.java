package com.alexmpdev.restaurantmanager.api.integrations;

import com.alexmpdev.restaurantmanager.RestaurantManagerApplication;
import com.alexmpdev.restaurantmanager.category_menu.model.CategoryMenu;
import com.alexmpdev.restaurantmanager.common.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(classes = RestaurantManagerApplication.class)
@AutoConfigureMockMvc(addFilters = false)
// @ActiveProfiles("test")
@Transactional
public class CategoryMenuIntegrationsTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void CategoryMenuIntegrations_GetAllCategoryMenu_Return2CategoryMenu() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/categoryMenu"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    @Test
    public void CategoryMenuIntegrations_GetCategoryMenu_ReturnCategoryMenu() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/categoryMenu/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    public void CategoryMenuIntegrations_Save_ReturnStatus200() throws Exception {

        CategoryMenu createCategoryMenu = getCategoryMenu("Prueba", 1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/categoryMenu")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createCategoryMenu)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void CategoryMenuIntegrations_Update_ReturnStatus200() throws Exception {

        CategoryMenu editCategoryMenu = getCategoryMenu("edit", 1);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/categoryMenu/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(editCategoryMenu)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void CategoryMenuIntegrations_Delete_ReturnStatus200() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/categoryMenu/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
