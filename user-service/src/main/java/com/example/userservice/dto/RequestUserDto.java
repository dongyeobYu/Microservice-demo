package com.example.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class RequestUserDto {

    @NotBlank(message = "email cannot be null")
    @Size(min = 2, message = "Email not be less than two characters")
    @Email
    private final String email;

    @NotBlank(message = "password cannot be null")
    @Size(min = 2, message = "password 2~8", max = 8)
    private final String password;

    @NotBlank(message = "name cannot be null")
    @Size(min = 2, max = 16)
    private final String name;


}
