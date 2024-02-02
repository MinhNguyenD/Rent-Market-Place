package com.mlproject.quickLease.controller;

import com.mlproject.quickLease.dto.RoomDto;
import com.mlproject.quickLease.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllRooms(){
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getRoom(@PathVariable String id){

    }

    @PostMapping
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto){

    }

    @PutMapping
    public ResponseEntity<RoomDto> updateRoom(@RequestBody RoomDto roomDto){

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoomDto> deleteRoom(@PathVariable String id){

    }

}
