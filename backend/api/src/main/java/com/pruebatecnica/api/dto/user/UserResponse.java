package com.pruebatecnica.api.dto.user;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean enabled;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}