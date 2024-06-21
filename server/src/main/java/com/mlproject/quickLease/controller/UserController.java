package com.mlproject.quickLease.controller;

import com.mlproject.quickLease.dto.UserDto;
import com.mlproject.quickLease.service.UserService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable int id){
        UserDto user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createUser(@RequestBody UserDto user){
        // if body contains id != 0 -> set it to 0 because this is create not update
        user.setId(0);
        userService.createUser(user);
        String message = "Created user with id " + user.getId();
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserDto user) {
        userService.updateUser(user);
        String message  = "Updated user with id " + user.getId();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        String response = "Deleted user with id " + id;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
