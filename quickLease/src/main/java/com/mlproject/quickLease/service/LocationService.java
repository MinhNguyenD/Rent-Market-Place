package com.mlproject.quickLease.service;

import com.mlproject.quickLease.dto.LocationDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface LocationService {
    List<LocationDto> getAllLocations();
    LocationDto getLocation(int id);
    LocationDto createLocation(LocationDto locationDto);
    LocationDto updateLocation(LocationDto locationDto);
    void deleteLocation(int id);
}
