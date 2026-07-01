package com.pruebatecnica.api.dto.project;

import java.time.LocalDate;
import java.util.UUID;

import com.pruebatecnica.api.core.enums.ProjectStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectResponse {

    private UUID id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private ProjectStatus status;

}