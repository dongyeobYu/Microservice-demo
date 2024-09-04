package com.example.userservice.controller;

import com.example.userservice.Greeting;
import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final Greeting greeting;

    private final UserService userService;

    @GetMapping("health_check")
    public String status(){
        return greeting.getMessage();
    }

    @PostMapping("users")
    public ResponseEntity<ResponseUserDto> createUser(@RequestBody RequestUserDto requestUserDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(requestUserDto));
    }
}
