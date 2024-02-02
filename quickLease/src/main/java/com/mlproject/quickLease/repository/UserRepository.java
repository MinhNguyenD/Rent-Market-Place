package com.mlproject.quickLease.repository;

import com.mlproject.quickLease.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    // Use Spring Data Jpa to reduce boiler codes of DAO
    // Spring Data JPA provides CRUD methods without the need to implement it
    // To use, Inject this interface UserRepository to UserService class and use all the CRUD methods (see document for method naming)
    Optional<UserEntity> findByEmail(String email);
    Boolean existsByEmail(String email);
}
