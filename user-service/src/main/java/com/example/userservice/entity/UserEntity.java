package com.example.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    private String userId;

    @Column(nullable = false)
    private String encryptedPassword;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public UserEntity(Long id, String email, String name, String userId, String encryptedPassword, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.userId = userId;
        this.encryptedPassword = encryptedPassword;
        this.createdAt = createdAt;
    }
}
