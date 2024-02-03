package com.mlproject.quickLease.service;

import com.mlproject.quickLease.dto.RoomDto;
import java.util.List;

public interface RoomService {
    List<RoomDto> getAllRooms();

    RoomDto getRoom(int id);

    RoomDto createRoom(RoomDto roomDto);

    RoomDto updateRoom(RoomDto roomDto);

    void deleteRoom(int id);
}
