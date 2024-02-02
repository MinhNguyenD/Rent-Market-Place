package com.mlproject.quickLease.controller;

import com.mlproject.quickLease.dto.RoomDto;
import com.mlproject.quickLease.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
@RequestMapping("api/rooms")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllRooms(){
        return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getRoom(@PathVariable int id){
        return new ResponseEntity<>(roomService.getRoom(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createRoom(@RequestBody RoomDto roomDto){
        roomService.saveRoom(roomDto);
        String message = "Created room with ID " + roomDto.getId();
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateRoom(@RequestBody RoomDto roomDto){
        roomService.saveRoom(roomDto);
        String message = "Updated room with ID " + roomDto.getId();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable int id){
        roomService.deleteRoom(id);
        String message = "Deleted room with ID " + id;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
