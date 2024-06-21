package com.mlproject.quickLease.repository;

import com.mlproject.quickLease.entity.UserEntity;
import com.mlproject.quickLease.exception.UserNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;

    // dependency injection
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        TypedQuery<UserEntity> query = entityManager.createQuery("from User", UserEntity.class);
        List<UserEntity> users = query.getResultList();
        return users;
    }

    @Override
    public UserEntity getUserById(int id){
        return entityManager.find(UserEntity.class, id);
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        // save or update depends on employee id
        // if Id == 0 -> save
        // if Id != 0 -> update
        UserEntity dbUser = entityManager.merge(user);
        return dbUser;
    }

    @Override
    public void deleteUserById(int id) {
        try {
            UserEntity deleteUser = entityManager.find(UserEntity.class, id);
            entityManager.remove(deleteUser);
        }
        catch (Exception e) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
    }
}
