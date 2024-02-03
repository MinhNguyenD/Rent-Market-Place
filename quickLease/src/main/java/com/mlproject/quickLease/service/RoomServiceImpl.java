package com.mlproject.quickLease.service;
import com.mlproject.quickLease.dto.RoomDto;
import com.mlproject.quickLease.entity.Location;
import com.mlproject.quickLease.entity.Room;
import com.mlproject.quickLease.exception.LocationNotFoundException;
import com.mlproject.quickLease.exception.RoomNotFoundException;
import com.mlproject.quickLease.mapper.RoomMapper;
import com.mlproject.quickLease.repository.LocationRepository;
import com.mlproject.quickLease.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    private final LocationRepository locationRepository;

    @Override
    public List<RoomDto> getAllRooms() {
        List<Room> allRooms = roomRepository.findAll();
        return allRooms.stream().map(roomMapper::mapToDto).toList();
    }

    @Override
    public RoomDto getRoom(int id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException("Room not found"));
        return roomMapper.mapToDto(room);
    }

    @Override
    @Transactional
    public RoomDto createRoom(RoomDto roomDto) {
        Location location = locationRepository.findById(roomDto.getLocationId()).orElseThrow(() -> new LocationNotFoundException("Location not found"));
        Room room =  roomMapper.mapToEntity(roomDto, location);
        roomRepository.save(room);
        return roomDto;
    }

    @Override
    @Transactional
    public RoomDto updateRoom(RoomDto roomDto) {
        roomRepository.findById(roomDto.getId()).orElseThrow(() -> new RoomNotFoundException("Room not found"));
        Location location = locationRepository.findById(roomDto.getLocationId()).orElseThrow(() -> new LocationNotFoundException("Location not found"));
        Room room = roomMapper.mapToEntity(roomDto,location);
        room.setId(roomDto.getId());
        roomRepository.save(room);
        return roomDto;
    }

    @Override
    @Transactional
    public void deleteRoom(int id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException("Room not found"));
        roomRepository.delete(room);
    }
}
