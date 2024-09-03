package com.alexmpdev.restaurantmanager.api.integrations;

import com.alexmpdev.restaurantmanager.RestaurantManagerApplication;
import com.alexmpdev.restaurantmanager.categories.model.Category;
import com.alexmpdev.restaurantmanager.common.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;


@SpringBootTest(classes = RestaurantManagerApplication.class)
@AutoConfigureMockMvc(addFilters = false)
// @ActiveProfiles("test")
// @Transactional
public class CategoriesIntegrationsTest extends BaseTest {


    @Autowired private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void CategoriesIntegrations_GetAllCategories_Returns4Categories() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/category"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)));

    }

    @Test
    public void CategoriesIntegrations_GetCategory_ReturnsCategory() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/category/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));

    }

    @Test
    public void CategoriesIntegrations_Create_ReturnsStatus200() throws Exception {

        Category createCategory = getCategory("Prueba");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/category")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createCategory)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void CategoriesIntegrations_Update_ReturnsStatus200() throws Exception {

        Category editCategory = getCategory("Edit");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/category/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(editCategory)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void CategoriesIntegrations_Delete_ReturnsStatus200() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/category/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}
