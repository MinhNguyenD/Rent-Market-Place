package com.mlproject.quickLease.mapper;

import com.mlproject.quickLease.dto.RoomDto;
import com.mlproject.quickLease.entity.Location;
import com.mlproject.quickLease.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    @Mapping(source = "location", target = "location")
    @Mapping(ignore = true)
    Room mapToEntity(Room room, RoomDto roomDto, Location location);
    RoomDto mapToDto(Room room);
}
