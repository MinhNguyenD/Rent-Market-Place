package com.mlproject.quickLease.dto;

import com.mlproject.quickLease.entity.Room;
import com.mlproject.quickLease.entity.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class BookingDto {
    private int id;

    @NotNull
    private int roomId;

    @NotNull
    private int userId;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private int numGuest;
}
