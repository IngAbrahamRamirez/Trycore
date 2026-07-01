package com.pruebatecnica.api.dto.user;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response containing user details with information returned by the API.")
public class UserResponse {

    @Schema(description = "The unique identifier of the user", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "The first name of the user", example = "John")
    private String firstName;

    @Schema(description = "The last name of the user", example = "Doe")
    private String lastName;

    @Schema(description = "The email address of the user", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Indicates if the user is enabled", example = "true")
    private Boolean enabled;

    @Schema(description = "The date and time when the user was created", example = "2023-01-01T00:00:00Z")
    private LocalDateTime createdAt;

    @Schema(description = "The date and time when the user was last updated", example = "2023-01-01T00:00:00Z")
    private LocalDateTime updatedAt;

}