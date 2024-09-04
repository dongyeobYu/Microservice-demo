package com.example.userservice.service;

import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseUserDto save(RequestUserDto requestUserDto) {

        UserEntity userEntity = UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .email(requestUserDto.getEmail())
                .encryptedPassword("encrypted_password")
                .name(requestUserDto.getName())
                .createdAt(LocalDateTime.now())
                .build();

        UserEntity savedUser = userRepository.save(userEntity);

        return ResponseUserDto.builder()
                .userId(savedUser.getUserId())
                .email(savedUser.getEmail())
                .name(savedUser.getName())
                .build();
    }

}
