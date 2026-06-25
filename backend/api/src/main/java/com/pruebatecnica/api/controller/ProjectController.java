package com.pruebatecnica.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.pruebatecnica.api.dto.request.ProjectRequest;
import com.pruebatecnica.api.dto.response.ProjectResponse;
import com.pruebatecnica.api.service.ProjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponse create(
            @Valid @RequestBody ProjectRequest request) {

        return projectService.create(request);
    }

    @GetMapping
    public List<ProjectResponse> findAll() {

        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public ProjectResponse findById(
            @PathVariable UUID id) {

        return projectService.findById(id);
    }

    @PutMapping("/{id}")
    public ProjectResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody ProjectRequest request) {

        return projectService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID id) {

        projectService.delete(id);
    }
}