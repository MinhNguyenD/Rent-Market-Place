package com.mlproject.quickLease.Services;

import com.mlproject.quickLease.DTOs.UserDto;
import com.mlproject.quickLease.Entities.UserEntity;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(int id);

    UserDto saveUser(UserDto user);

    void deleteUserById(int id);
    String registerUser(UserDto userDto);
}
