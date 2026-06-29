package com.pruebatecnica.api.dto.project;

import java.time.LocalDate;
import java.util.UUID;

import com.pruebatecnica.api.core.enums.ProjectStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectRequest {

    @NotNull
    private UUID userId;

    @NotBlank
    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @NotNull
    private ProjectStatus status;

}