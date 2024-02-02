package com.mlproject.quickLease.service;

import com.mlproject.quickLease.dto.RoomDto;
import java.util.List;

public interface RoomService {
    public List<RoomDto> getAllRooms();

    public RoomDto getRoom(String id);

    public RoomDto createRoom(RoomDto roomDto);

    public RoomDto updateRoom(RoomDto roomDto);

    public RoomDto deleteRoom(String id);
}
