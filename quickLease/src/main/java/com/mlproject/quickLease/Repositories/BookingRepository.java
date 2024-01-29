package com.mlproject.quickLease.Repositories;

import com.mlproject.quickLease.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
