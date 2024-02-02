package com.mlproject.quickLease.service;
import com.mlproject.quickLease.dto.RoomDto;
import com.mlproject.quickLease.entity.Room;
import com.mlproject.quickLease.repository.RoomRepository;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public List<RoomDto> getAllRooms() {
        List<Room> allRooms = roomRepository.findAll();
        return ;
    }

    @Override
    public RoomDto getRoom(String id) {
        return null;
    }

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        return null;
    }

    @Override
    public RoomDto updateRoom(RoomDto roomDto) {
        return null;
    }

    @Override
    public RoomDto deleteRoom(String id) {
        return null;
    }
}
