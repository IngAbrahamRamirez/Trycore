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

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    private final ActivityMetricsService activityMetricsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityResponse create(
            @Valid @RequestBody ActivityRequest request) {

        return activityService.create(request);
    }

    @GetMapping
    public List<ActivityResponse> findAll() {

        return activityService.findAll();
    }

    @GetMapping("/{id}")
    public ActivityResponse findById(
            @PathVariable UUID id) {

        return activityService.findById(id);
    }

    @GetMapping("/project/{projectId}")
    public List<ActivityResponse> findByProject(
            @PathVariable UUID projectId) {

        return activityService.findByProject(projectId);
    }

    @GetMapping("/{id}/metrics")
    public MetricsResponse getMetrics(
            @PathVariable UUID id) {

        return activityMetricsService.calculate(id);
    }

    @PutMapping("/{id}")
    public ActivityResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody ActivityRequest request) {

        return activityService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID id) {

        activityService.delete(id);
    }

}