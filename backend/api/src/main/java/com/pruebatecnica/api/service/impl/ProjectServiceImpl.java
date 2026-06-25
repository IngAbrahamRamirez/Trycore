package com.pruebatecnica.api.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.pruebatecnica.api.dto.request.ProjectRequest;
import com.pruebatecnica.api.dto.response.ProjectResponse;
import com.pruebatecnica.api.entity.Project;
import com.pruebatecnica.api.exception.ResourceNotFoundException;
import com.pruebatecnica.api.repository.ProjectRepository;
import com.pruebatecnica.api.service.ProjectService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectResponse create(ProjectRequest request) {

        Project project = Project.builder()
                .name(request.getName())
                .description(request.getDescription())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .status(request.getStatus())
                .build();

        project = projectRepository.save(project);

        return mapToResponse(project);
    }

    @Override
    public List<ProjectResponse> findAll() {

        return projectRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ProjectResponse findById(UUID id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found"));

        return mapToResponse(project);
    }

    @Override
    public ProjectResponse update(UUID id, ProjectRequest request) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found"));

        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setStartDate(request.getStartDate());
        project.setEndDate(request.getEndDate());
        project.setStatus(request.getStatus());

        project = projectRepository.save(project);

        return mapToResponse(project);
    }

    @Override
    public void delete(UUID id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found"));

        projectRepository.delete(project);
    }

    private ProjectResponse mapToResponse(Project project) {

        return ProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .status(project.getStatus())
                .build();
    }
}