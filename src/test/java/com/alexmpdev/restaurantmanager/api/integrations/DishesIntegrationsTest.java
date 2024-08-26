package com.alexmpdev.restaurantmanager.api.integrations;

import com.alexmpdev.restaurantmanager.RestaurantManagerApplication;
import com.alexmpdev.restaurantmanager.common.BaseTest;
import com.alexmpdev.restaurantmanager.dishes.model.Dish;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;

@SpringBootTest(classes = RestaurantManagerApplication.class)
@AutoConfigureMockMvc(addFilters = false)
// @ActiveProfiles("test")
@Transactional
public class DishesIntegrationsTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void DishesIntegrations_GetAllDishes_Returns2Dishes() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/dishes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));

    }

    @Test
    public void DishesIntegrations_GetDish_ReturnsDish() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/dishes/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    public void DishesIntegrations_Save_ReturnsStatus200() throws Exception {
        Dish createDish = getDish();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/dishes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createDish)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void DishesIntegrations_Update_ReturnsStatus200() throws Exception {

        Dish editDish = getDish();

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/dishes/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(editDish)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void DishesIntegrations_Delete_ReturnsStatus200() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/dishes/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
