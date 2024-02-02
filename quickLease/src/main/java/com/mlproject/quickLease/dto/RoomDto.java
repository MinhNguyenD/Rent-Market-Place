package com.mlproject.quickLease.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomDto {
    private int id;
    @NotNull
    private int numBedroom;
    @NotNull
    private int numBed;
    @NotNull
    private int numBathRoom;
    @NotBlank
    private String roomDescription;
    @NotNull
    private int costPerDay;
    private int locationId;
}
