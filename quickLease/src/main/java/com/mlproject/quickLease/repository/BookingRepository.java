package com.mlproject.quickLease.repository;

import com.mlproject.quickLease.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
