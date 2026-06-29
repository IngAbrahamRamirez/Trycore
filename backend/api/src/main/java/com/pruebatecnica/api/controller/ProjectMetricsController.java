package com.pruebatecnica.api.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.api.dto.common.MetricsResponse;
import com.pruebatecnica.api.service.evm.ProjectMetricsService;

import lombok.RequiredArgsConstructor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequiredArgsConstructor
@Tag(name = "Project Metrics", description = "Operations related to project metrics")
public class ProjectMetricsController {

    private final ProjectMetricsService projectMetricsService;

    @Operation(summary = "Calculate EVM metrics", description = "Calculates the earned value management metrics of an activity.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Metrics retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Project not found")
    })
    @GetMapping("/api/projects/{projectId}/metrics")
    public MetricsResponse calculate(
            @PathVariable UUID projectId) {

        return projectMetricsService.calculate(projectId);
    }

}