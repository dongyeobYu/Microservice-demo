package com.example.userservice.service;

import com.example.userservice.dto.RequestUser;
import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto save(RequestUser requestUser) {

        UserEntity userEntity = UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .email(requestUser.getEmail())
                .encryptedPassword("encrypted_password")
                .name(requestUser.getName())
                .build();

        userRepository.save(userEntity);

        return null;
    }

}
