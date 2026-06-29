package com.pruebatecnica.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.pruebatecnica.api.dto.activity.ActivityRequest;
import com.pruebatecnica.api.dto.activity.ActivityResponse;
import com.pruebatecnica.api.dto.common.MetricsResponse;
import com.pruebatecnica.api.service.activity.ActivityMetricsService;
import com.pruebatecnica.api.service.activity.ActivityService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
@Tag(name = "Activities", description = "Operations related to activity management")
public class ActivityController {

    private final ActivityService activityService;

    private final ActivityMetricsService activityMetricsService;

    @PostMapping
    @Operation(summary = "Create activity", description = "Creates a new activity.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Activity created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityResponse create(
            @Valid @RequestBody ActivityRequest request) {

        return activityService.create(request);
    }

    @GetMapping
    @Operation(summary = "Find all activities", description = "Retrieves a list of all activities.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Activities retrieved successfully")
    })
    public List<ActivityResponse> findAll() {

        return activityService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find activity by ID", description = "Retrieves an activity by their unique identifier.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Activity retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Activity not found")
    })
    public ActivityResponse findById(
            @PathVariable UUID id) {

        return activityService.findById(id);
    }

    @GetMapping("/project/{projectId}")
    @Operation(summary = "Find activities by project", description = "Retrieves a list of activities associated with a specific project.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Activities retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Project not found")
    })

    public List<ActivityResponse> findByProject(
            @PathVariable UUID projectId) {

        return activityService.findByProject(projectId);
    }

    @GetMapping("/{id}/metrics")
    @Operation(summary = "Get activity metrics", description = "Retrieves metrics for a specific activity.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Metrics retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Activity not found")
    })
    public MetricsResponse getMetrics(
            @PathVariable UUID id) {

        return activityMetricsService.calculate(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update activity", description = "Updates an existing activity.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Activity updated successfully"),
            @ApiResponse(responseCode = "404", description = "Activity not found"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    public ActivityResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody ActivityRequest request) {

        return activityService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete activity", description = "Deletes an activity by their unique identifier.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Activity deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Activity not found")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID id) {

        activityService.delete(id);
    }

}