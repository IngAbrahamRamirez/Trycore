package com.pruebatecnica.api.dto.project;

import java.time.LocalDate;
import java.util.UUID;

import com.pruebatecnica.api.core.enums.ProjectStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Request used to create or update projects.")
public class ProjectRequest {

    @NotNull
    @Schema(description = "The ID of the user who owns the project", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID userId;

    @NotBlank
    @Schema(description = "The name of the project", example = "Project Alpha")
    private String name;

    @Schema(description = "The description of the project", example = "This is a sample project for demonstration purposes.")
    private String description;

    @Schema(description = "The start date of the project", example = "2023-01-01")
    private LocalDate startDate;

    @Schema(description = "The end date of the project", example = "2023-12-31")
    private LocalDate endDate;

    @NotNull
    @Schema(description = "The status of the project", example = "ACTIVE")
    private ProjectStatus status;

}