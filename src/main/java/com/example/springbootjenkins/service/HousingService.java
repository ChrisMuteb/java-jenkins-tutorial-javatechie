package com.example.springbootjenkins.service;

import com.example.springbootjenkins.controller.HousingController;
import com.example.springbootjenkins.dto.HousingRequest;
import com.example.springbootjenkins.dto.HousingResponse;
import com.example.springbootjenkins.entity.Housing;
import com.example.springbootjenkins.mapper.HousingMapper;
import com.example.springbootjenkins.repository.HousingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HousingService {
    @Autowired
    private HousingRepository housingRepository;
    @Autowired
    private HousingMapper housingMapper;
    public static Logger logger = LoggerFactory.getLogger(HousingService.class);

    // Method to get the list of housing responses
    public List<HousingResponse> findAllHousing() {
        return housingRepository.findAll().stream()
                .map(housingMapper::fromHousing)
                .collect(Collectors.toList());
    }

    public HousingResponse saveHousing(HousingRequest request){
        Housing housing = new HousingMapper().toHousing(request);
        var savedHousing = housingRepository.save(housing);
        return new HousingMapper().fromHousing(savedHousing);
    }



}
