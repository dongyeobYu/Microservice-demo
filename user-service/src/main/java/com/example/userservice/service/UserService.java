package com.example.userservice.service;

import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseUserDto save(RequestUserDto requestUserDto) {

        UserEntity userEntity = UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .email(requestUserDto.getEmail())
                .encryptedPassword(bCryptPasswordEncoder.encode(requestUserDto.getPassword()))
                .name(requestUserDto.getName())
                .createdAt(LocalDateTime.now())
                .build();

        UserEntity savedUser = userRepository.save(userEntity);

        return ResponseUserDto.builder()
                .userId(savedUser.getUserId())
                .email(savedUser.getEmail())
                .name(savedUser.getName())
                .createdAt(savedUser.getCreatedAt())
                .build();
    }

    public List<ResponseUserDto> findByAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(
                        dto -> ResponseUserDto.builder()
                                .userId(dto.getUserId())
                                .email(dto.getEmail())
                                .name(dto.getName())
                                .createdAt(dto.getCreatedAt())
                                .build()
                ).toList();
    }

    public ResponseUserDto findUserById(String userId) {

        Optional<ResponseUserDto> optionalResponseUserDto = userRepository.findUserByUserId(userId).map(dto -> ResponseUserDto.builder()
                .userId(dto.getUserId())
                .email(dto.getEmail())
                .name(dto.getName())
                .createdAt(dto.getCreatedAt())
                .build());

        return optionalResponseUserDto.orElse(null);

    }
}
