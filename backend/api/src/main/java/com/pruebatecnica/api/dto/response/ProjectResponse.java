package com.pruebatecnica.api.dto.response;

import java.time.LocalDate;
import java.util.UUID;

import com.pruebatecnica.api.core.enums.ProjectStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectResponse {

    private UUID id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private ProjectStatus status;
}