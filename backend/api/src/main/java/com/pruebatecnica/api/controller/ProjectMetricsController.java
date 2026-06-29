package com.pruebatecnica.api.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.api.dto.common.MetricsResponse;
import com.pruebatecnica.api.service.evm.ProjectMetricsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProjectMetricsController {

    private final ProjectMetricsService projectMetricsService;

    @GetMapping("/api/projects/{projectId}/metrics")
    public MetricsResponse calculate(
            @PathVariable UUID projectId) {

        return projectMetricsService.calculate(projectId);
    }

}