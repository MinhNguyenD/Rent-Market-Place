package com.mlproject.quickLease.Repositories;

import com.mlproject.quickLease.Entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
