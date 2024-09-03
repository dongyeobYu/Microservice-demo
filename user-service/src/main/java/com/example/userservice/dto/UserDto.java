package com.example.userservice.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UserDto {

    private String email;

    private String name;

    private String userId;

    private String encryptedPassword;
}
