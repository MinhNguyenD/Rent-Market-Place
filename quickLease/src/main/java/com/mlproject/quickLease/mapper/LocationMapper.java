package com.mlproject.quickLease.mapper;

import com.mlproject.quickLease.dto.LocationDto;
import com.mlproject.quickLease.entity.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    @Mapping(target = "id", ignore = true)
    Location mapToEntity(LocationDto locationDto);

    LocationDto mapToDto(Location location);
}
