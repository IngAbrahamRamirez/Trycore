package com.pruebatecnica.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.pruebatecnica.api.dto.project.ProjectRequest;
import com.pruebatecnica.api.dto.project.ProjectResponse;
import com.pruebatecnica.api.service.project.ProjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;


@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
@Tag(name = "Projects", description = "Operations related to project management")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    @Operation(summary = "Create project", description = "Creates a new project.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Project created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "404", description = "Error creating project")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponse create(
            @Valid @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Project information", required = true) ProjectRequest request) {

        return projectService.create(request);
    }

    @GetMapping
    @Operation(summary = "Find all projects", description = "Retrieves a list of all projects.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Projects retrieved successfully")
    })
    public List<ProjectResponse> findAll() {

        return projectService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find project by ID", description = "Retrieves a project by their unique identifier.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Project retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Project not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @Parameter(description = "Project identifier", example = "4efaf7d0-87c2-4a6f-a6d4-6b1f7e2d4b8a")
    public ProjectResponse findById(
            @PathVariable UUID id) {

        return projectService.findById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update project", description = "Updates an existing project.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Project updated successfully"),
            @ApiResponse(responseCode = "404", description = "Project not found"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
          })
    @Parameter(description = "Project identifier", example = "4efaf7d0-87c2-4a6f-a6d4-6b1f7e2d4b8a")
    public ProjectResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Project information to update", required = true) ProjectRequest request) {

        return projectService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete project", description = "Deletes a project by their unique identifier.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Project deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Project not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @Parameter(description = "Project identifier", example = "4efaf7d0-87c2-4a6f-a6d4-6b1f7e2d4b8a")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID id) {

        projectService.delete(id);
    }
}