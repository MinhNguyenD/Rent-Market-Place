package com.mlproject.quickLease.DTOs;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;

    private String password;
}
