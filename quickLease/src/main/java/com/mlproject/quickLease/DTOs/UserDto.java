package com.mlproject.quickLease.DTOs;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private int id;

    private String fullName;

    private String email;

    private String password;

    private String phoneNumber;

    private Date dateOfBirth;

    private boolean gender;

    public UserDto() {
    }

    public UserDto(int id, String fullName, String email, String password, String phoneNumber, Date dateOfBirth, boolean gender) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
}
