package com.pruebatecnica.api.dto.request;

import java.time.LocalDate;

import com.pruebatecnica.api.core.enums.ProjectStatus;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectRequest {

    @NotBlank
    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private ProjectStatus status;
}