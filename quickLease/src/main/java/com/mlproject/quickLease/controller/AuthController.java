package com.mlproject.quickLease.controller;

import com.mlproject.quickLease.dto.AuthenticationResponseDto;
import com.mlproject.quickLease.dto.LoginRequestDto;
import com.mlproject.quickLease.dto.UserDto;
import com.mlproject.quickLease.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

/*    @Autowired
    public AuthRestController(UserService userService) {
        this.userService = userService;
    }*/

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody UserDto registerDto){
        return new ResponseEntity<>(userService.registerUser(registerDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody LoginRequestDto loginDto){
        return new ResponseEntity<>(userService.loginUser(loginDto), HttpStatus.OK);
    }
}
