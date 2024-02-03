package com.mlproject.quickLease.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomDto {
    private int id;
    @NotNull
    private int numBedRoom;
    @NotNull
    private int numBathRoom;
    @NotNull
    private int numBed;
    @NotBlank
    private String roomDescription;
    @NotNull
    private int costPerDay;
    private int locationId;
}
