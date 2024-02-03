package com.mlproject.quickLease.service;

import com.mlproject.quickLease.dto.AuthenticationResponseDto;
import com.mlproject.quickLease.dto.LoginRequestDto;
import com.mlproject.quickLease.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUser(int id);

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);

    void deleteUser(int id);
    AuthenticationResponseDto registerUser(UserDto userDto);
    AuthenticationResponseDto loginUser(LoginRequestDto loginRequestDto);
}
