package com.mlproject.quickLease.repository;

import com.mlproject.quickLease.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
