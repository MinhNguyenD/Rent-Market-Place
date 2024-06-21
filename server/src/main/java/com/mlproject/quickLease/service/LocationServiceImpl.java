package com.mlproject.quickLease.service;

import com.mlproject.quickLease.dto.LocationDto;
import com.mlproject.quickLease.entity.Location;
import com.mlproject.quickLease.exception.LocationNotFoundException;
import com.mlproject.quickLease.mapper.LocationMapper;
import com.mlproject.quickLease.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService{
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    @Override
    public List<LocationDto> getAllLocations() {
        return locationRepository.findAll().stream().map(locationMapper::mapToDto).toList();
    }

    @Override
    public LocationDto getLocation(int id) {
        return locationMapper.mapToDto(locationRepository.findById(id).orElseThrow(() -> new LocationNotFoundException("Location not found")));
    }

    @Override
    public LocationDto createLocation(LocationDto locationDto) {
        Location location = locationMapper.mapToEntity(locationDto);
        locationRepository.save(location);
        return locationDto;
    }

    @Override
    public LocationDto updateLocation(LocationDto locationDto) {
        locationRepository.findById(locationDto.getId()).orElseThrow(() -> new LocationNotFoundException("Location not found"));
        Location location = locationMapper.mapToEntity(locationDto);
        location.setId(locationDto.getId());
        locationRepository.save(location);
        return locationDto;
    }

    @Override
    public void deleteLocation(int id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new LocationNotFoundException("Location not found"));
        locationRepository.delete(location);
    }
}
