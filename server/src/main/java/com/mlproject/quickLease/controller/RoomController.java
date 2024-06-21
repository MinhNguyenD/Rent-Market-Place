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
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto){
        return new ResponseEntity<>(roomService.createRoom(roomDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<RoomDto> updateRoom(@RequestBody RoomDto roomDto){
        return new ResponseEntity<>(roomService.updateRoom(roomDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable int id){
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
