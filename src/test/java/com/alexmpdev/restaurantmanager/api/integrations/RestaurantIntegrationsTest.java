package com.alexmpdev.restaurantmanager.api.integrations;

import com.alexmpdev.restaurantmanager.RestaurantManagerApplication;
import com.alexmpdev.restaurantmanager.common.BaseTest;
import com.alexmpdev.restaurantmanager.restaurants.model.Restaurant;
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
public class RestaurantIntegrationsTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void RestaurantIntegrations_GetAllRestaurants_Return8Restaurants() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/restaurant"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(8)));
    }

    @Test
    public void RestaurantIntegrations_GetRestaurants_ReturnRestaurant() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/restaurant/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    public void RestaurantIntegrations_Save_ReturnStatus200() throws Exception {

        Restaurant createRestaurant = getRestaurant(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/restaurant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createRestaurant)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void RestaurantIntegrations_Update_ReturnStatus200() throws Exception {

        Restaurant editRestaurant = getRestaurant(1);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/restaurant/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(editRestaurant)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void RestaurantIntegrations_Delete_ReturnStatus200() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/restaurant/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
