package com.mlproject.quickLease.mapper;

import com.mlproject.quickLease.dto.RoomDto;
import com.mlproject.quickLease.entity.Location;
import com.mlproject.quickLease.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    @Mapping(source = "location", target = "location")
    @Mapping(target = "id",ignore = true)
    Room mapToEntity(RoomDto roomDto, Location location);

    @Mapping(target = "locationId", expression = "java(room.getLocation().getId())")
    RoomDto mapToDto(Room room);
}
