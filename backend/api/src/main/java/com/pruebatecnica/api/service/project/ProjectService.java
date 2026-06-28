package com.pruebatecnica.api.service.project;

import java.util.List;
import java.util.UUID;

import com.pruebatecnica.api.dto.request.ProjectRequest;
import com.pruebatecnica.api.dto.response.ProjectResponse;

public interface ProjectService {

    ProjectResponse create(ProjectRequest request);

    List<ProjectResponse> findAll();

    ProjectResponse findById(UUID id);

    ProjectResponse update(UUID id, ProjectRequest request);

    void delete(UUID id);
}