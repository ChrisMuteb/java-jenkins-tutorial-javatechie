package com.example.springbootjenkins.service;

import com.example.springbootjenkins.controller.HousingController;
import com.example.springbootjenkins.dto.HousingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HousingService {
    private final List<HousingResponse> housingResponseList;
    public static Logger logger = LoggerFactory.getLogger(HousingService.class);

    // Constructor to initialize the list and add sample data
    public HousingService() {
        this.housingResponseList = new ArrayList<>();
        initializeHousingList();
    }

    // Method to initialize the list with sample data
    private void initializeHousingList() {
        HousingResponse hr = new HousingResponse(1L, "Heloise", "104 av de Paris", "Paris");
        housingResponseList.add(hr);
    }

    // Method to get the list of housing responses
    public List<HousingResponse> getHousingResponses() {
        return new ArrayList<>(housingResponseList);
    }

}
