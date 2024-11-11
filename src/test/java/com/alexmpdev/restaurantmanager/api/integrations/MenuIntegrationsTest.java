package com.alexmpdev.restaurantmanager.api.integrations;

import com.alexmpdev.restaurantmanager.RestaurantManagerApplication;
import com.alexmpdev.restaurantmanager.common.BaseTest;
import com.alexmpdev.restaurantmanager.menu.model.Menu;
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
class MenuIntegrationsTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void MenuIntegrations_GetAllMenu_Return2Menu() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));

    }

    @Test
    void MenuIntegrations_GetMenu_ReturnMenu() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    void MenuIntegrations_Save_ReturnStatus200() throws Exception {
        Menu createMenu = getMenu(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/menu")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createMenu)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void MenuIntegrations_Update_ReturnStatus200() throws Exception {
        Menu editMenu = getMenu(1);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/menu/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(editMenu)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void MenuIntegrations_Delete_ReturnStatus200()throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/menu/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
