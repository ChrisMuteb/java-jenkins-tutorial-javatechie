package com.example.springbootjenkins.dto;

public record HousingRequest(
        Long id,
        String name,
        String address,
        String city
) {
}
