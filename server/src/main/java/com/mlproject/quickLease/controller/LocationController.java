package com.mlproject.quickLease.controller;

import com.mlproject.quickLease.dto.LocationDto;
import com.mlproject.quickLease.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/locations")
@AllArgsConstructor
public class LocationController {
    private final LocationService locationService;
    @GetMapping
    public ResponseEntity<List<LocationDto>> getAllLocations(){
        return new ResponseEntity<>(locationService.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> getLocation(@PathVariable int id){
        return new ResponseEntity<>(locationService.getLocation(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto){
        return new ResponseEntity<>(locationService.createLocation(locationDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LocationDto> updateLocation(@RequestBody LocationDto locationDto){
        return new ResponseEntity<>(locationService.updateLocation(locationDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable int id){
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
