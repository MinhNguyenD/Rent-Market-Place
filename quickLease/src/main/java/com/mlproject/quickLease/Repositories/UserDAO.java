package com.mlproject.quickLease.Repositories;

import com.mlproject.quickLease.Entities.UserEntity;

import java.util.List;

public interface UserDAO {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(int id);

    UserEntity saveUser(UserEntity user);

    void deleteUserById(int id);
}
