package com.example.springbootjenkins.dto;

public record HousingResponse(
        Long id,
        String name,
        String address,
        String city
){ }
