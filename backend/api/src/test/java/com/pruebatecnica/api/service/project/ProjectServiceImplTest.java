package com.pruebatecnica.api.service.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pruebatecnica.api.domain.entity.Project;
import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.dto.project.ProjectRequest;
import com.pruebatecnica.api.dto.project.ProjectResponse;
import com.pruebatecnica.api.fixtures.ProjectFactory;
import com.pruebatecnica.api.fixtures.UserFactory;
import com.pruebatecnica.api.mapper.ProjectMapper;
import com.pruebatecnica.api.repository.ProjectRepository;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    private ProjectRepository repository;

    @Mock
    private ProjectMapper mapper;

    @Mock
    private ProjectValidator validator;

    @InjectMocks
    private ProjectServiceImpl service;

    private User user;

    private Project project;

    private ProjectRequest request;

    private ProjectResponse response;

    @BeforeEach
    void setUp() {

        user = UserFactory.entity();

        project = ProjectFactory.entity(user);

        request = ProjectFactory.request(user.getId());

        response = ProjectFactory.response(project);

    }

    @Test
    @DisplayName("Should create project")
    void shouldCreateProject() {

        when(validator.validateUser(user.getId()))
                .thenReturn(user);

        when(mapper.toEntity(request))
                .thenReturn(project);

        when(repository.save(project))
                .thenReturn(project);

        when(mapper.toResponse(project))
                .thenReturn(response);

        ProjectResponse result = service.create(request);

        assertSame(response, result);

        verify(repository).save(project);

    }

    @Test
    @DisplayName("Should find all projects")
    void shouldFindAllProjects() {

        when(repository.findAll())
                .thenReturn(List.of(project));

        when(mapper.toResponseList(List.of(project)))
                .thenReturn(List.of(response));

        List<ProjectResponse> result = service.findAll();

        assertEquals(1, result.size());

        verify(repository).findAll();

    }

    @Test
    @DisplayName("Should find project by id")
    void shouldFindProjectById() {

        when(validator.validateProject(project.getId()))
                .thenReturn(project);

        when(mapper.toResponse(project))
                .thenReturn(response);

        ProjectResponse result = service.findById(project.getId());

        assertSame(response, result);

    }

    @Test
    @DisplayName("Should update project")
    void shouldUpdateProject() {

        when(validator.validateProject(project.getId()))
                .thenReturn(project);

        when(validator.validateUser(user.getId()))
                .thenReturn(user);

        doNothing().when(mapper)
                .updateEntity(request, project);

        when(repository.save(project))
                .thenReturn(project);

        when(mapper.toResponse(project))
                .thenReturn(response);

        ProjectResponse result = service.update(project.getId(), request);

        assertSame(response, result);

        verify(mapper).updateEntity(request, project);

    }

    @Test
    @DisplayName("Should delete project")
    void shouldDeleteProject() {

        when(validator.validateProject(project.getId()))
                .thenReturn(project);

        service.delete(project.getId());

        verify(repository).delete(project);

    }

}