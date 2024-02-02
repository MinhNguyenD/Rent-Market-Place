package com.mlproject.quickLease.service;

import com.mlproject.quickLease.dto.RoomDto;
import java.util.List;

public interface RoomService {
    public List<RoomDto> getAllRooms();

    public RoomDto getRoom(int id);

    public void saveRoom(RoomDto roomDto);

    public void deleteRoom(int id);
}
