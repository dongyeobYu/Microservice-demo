package com.example.userservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ResponseUserDto {

    private String email;

    private String name;

    private String userId;

    private LocalDateTime createdAt;

    public ResponseUserDto() {
    }

    @Builder
    public ResponseUserDto(String email, String name, String userId, LocalDateTime createdAt) {
        this.email = email;
        this.name = name;
        this.userId = userId;
        this.createdAt = createdAt;
    }
}
