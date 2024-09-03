package com.example.userservice.controller;

import com.example.userservice.Greeting;
import com.example.userservice.dto.RequestUser;
import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
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
    public String createUser(@RequestBody RequestUser requestUser){
        userService.save(requestUser);
        return null;
    }
}
