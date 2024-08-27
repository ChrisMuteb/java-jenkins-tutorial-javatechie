package com.example.springbootjenkins.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "housing")
@SequenceGenerator(
        name = "HOUSING_SEQ_GENERATOR",
        sequenceName = "HOUSING_SEQ",
        initialValue = 3647, allocationSize = 1
)
public class Housing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOUSING_SEQ_GENERATOR")
    @Column(name = "H_ID")
    private Long id;
    @Column(name = "H_NAME")
    private String name;
    @Column(name = "H_ADDRESS")
    private String address;
    @Column(name = "H_CITY")
    private String city;
}
