package com.example.springbootjenkins.controller;

import com.example.springbootjenkins.dto.HousingResponse;
import com.example.springbootjenkins.service.HousingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HousingController.class)
public class HousingControllerTest {
    @Autowired
    private MockMvc mockMvc;  // MockMvc simulates HTTP requests to the controller

    @MockBean
    private HousingService housingService;  // Mock the HousingService to simulate the service behavior

    @Test
    public void findAllHousing_ReturnsHousingList() throws Exception {
        // Arrange: Prepare the mock data and behavior
        HousingResponse hr = new HousingResponse(1L, "Heloise", "104 av de Paris", "Paris");
        when(housingService.findAllHousing()).thenReturn(Arrays.asList(hr));  // Mock the findAllHousing method

        // Act & Assert: Perform the GET request and verify the response
        mockMvc.perform(get("/v1/housing")  // Perform a GET request to the endpoint
                        .contentType(MediaType.APPLICATION_JSON))  // Specify the request content type
                .andExpect(status().isOk())  // Expect the HTTP status 200 OK
                .andExpect(header().string("Custom-Header", "foo"))  // Expect the custom header to be present
                .andExpect(jsonPath("$[0].id").value(1L))  // Expect the first element's id to be 1L
                .andExpect(jsonPath("$[0].name").value("Heloise"))  // Expect the name to be "Heloise"
                .andExpect(jsonPath("$[0].address").value("104 av de Paris"))  // Expect the address to be "104 av de Paris"
                .andExpect(jsonPath("$[0].city").value("Paris"));  // Expect the city to be "Paris"
    }
}
