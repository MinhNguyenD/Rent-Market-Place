package com.mlproject.quickLease.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LocationDto {
    private int id;

    @NotBlank(message = "Location name should not be null or empty")
    private String locationName;

    @NotBlank(message = "Country should not be null or empty")
    private String country;

    @NotBlank(message = "Province should not be null or empty")
    private String province;

    @NotBlank(message = "City should not be null or empty")
    private String city;
}
