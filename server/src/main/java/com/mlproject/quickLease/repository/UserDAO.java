package com.mlproject.quickLease.repository;

import com.mlproject.quickLease.entity.UserEntity;

import java.util.List;

public interface UserDAO {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(int id);

    UserEntity saveUser(UserEntity user);

    void deleteUserById(int id);
}
