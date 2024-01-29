package com.mlproject.quickLease.Repositories;

import com.mlproject.quickLease.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
