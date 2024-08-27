package com.example.springbootjenkins.controller;

import com.example.springbootjenkins.SpringbootjenkinsApplication;
import com.example.springbootjenkins.dto.HousingResponse;
import com.example.springbootjenkins.service.HousingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/housing")
public class HousingController {
    @Autowired
    private HousingService housingService;

    public static Logger logger = LoggerFactory.getLogger(HousingController.class);

    @GetMapping
    public ResponseEntity<List<HousingResponse>> findAllHousing(){
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(housingService.getHousingResponses());
    }
}
