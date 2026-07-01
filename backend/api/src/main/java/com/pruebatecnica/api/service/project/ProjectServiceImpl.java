package com.pruebatecnica.api.service.project;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.api.domain.entity.Project;
import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.dto.project.ProjectRequest;
import com.pruebatecnica.api.dto.project.ProjectResponse;
import com.pruebatecnica.api.mapper.ProjectMapper;
import com.pruebatecnica.api.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final ProjectValidator projectValidator;

    @Override
    public ProjectResponse create(ProjectRequest request) {

        User user = projectValidator.validateUser(request.getUserId());

        Project project = projectMapper.toEntity(request);

        project.setUser(user);

        project = projectRepository.save(project);

        return projectMapper.toResponse(project);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectResponse> findAll() {

        return projectMapper.toResponseList(projectRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectResponse findById(UUID id) {

        return projectMapper.toResponse(
                projectValidator.validateProject(id));
    }

    @Override
    public ProjectResponse update(UUID id, ProjectRequest request) {

        Project project = projectValidator.validateProject(id);

        User user = projectValidator.validateUser(request.getUserId());

        projectMapper.updateEntity(request, project);

        project.setUser(user);

        project = projectRepository.save(project);

        return projectMapper.toResponse(project);
    }

    @Override
    public void delete(UUID id) {

        projectRepository.delete(
                projectValidator.validateProject(id));
    }

}