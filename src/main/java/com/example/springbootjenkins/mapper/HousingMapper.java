package com.example.springbootjenkins.mapper;

import com.example.springbootjenkins.dto.HousingRequest;
import com.example.springbootjenkins.dto.HousingResponse;
import com.example.springbootjenkins.entity.Housing;
import org.springframework.stereotype.Service;

@Service
public class HousingMapper {
    public HousingResponse fromHousing(Housing housing){
        return new HousingResponse(
                housing.getId(),
                housing.getName(),
                housing.getAddress(),
                housing.getCity()
        );
    }

    public Housing toHousing(HousingRequest housingRequest){
        if(housingRequest == null)
            return null;

        return Housing.builder()
                .id(housingRequest.id())
                .name(housingRequest.name())
                .address(housingRequest.address())
                .city(housingRequest.city())
                .build();
    }
}
