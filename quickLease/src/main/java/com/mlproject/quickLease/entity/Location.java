package com.mlproject.quickLease.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name = "location_name")
    @NotBlank(message = "Location name should not be null or empty")
    private String locationName;

    @Column(name = "country")
    @NotBlank(message = "Country should not be null or empty")
    private String country;

    @Column(name = "province")
    @NotBlank(message = "Province should not be null or empty")
    private String province;

    @Column(name = "city")
    @NotBlank(message = "City should not be null or empty")
    private String city;
}
