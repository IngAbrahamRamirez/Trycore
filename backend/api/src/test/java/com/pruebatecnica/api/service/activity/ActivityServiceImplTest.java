package com.pruebatecnica.api.service.activity;

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

import com.pruebatecnica.api.domain.entity.Activity;
import com.pruebatecnica.api.domain.entity.Project;
import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.dto.activity.ActivityRequest;
import com.pruebatecnica.api.dto.activity.ActivityResponse;
import com.pruebatecnica.api.fixtures.ActivityFactory;
import com.pruebatecnica.api.fixtures.ProjectFactory;
import com.pruebatecnica.api.fixtures.UserFactory;
import com.pruebatecnica.api.mapper.ActivityMapper;
import com.pruebatecnica.api.repository.ActivityRepository;

@ExtendWith(MockitoExtension.class)
class ActivityServiceImplTest {

    @Mock
    private ActivityRepository repository;

    @Mock
    private ActivityMapper mapper;

    @Mock
    private ActivityValidator validator;

    @InjectMocks
    private ActivityServiceImpl service;

    private User user;

    private Project project;

    private Activity activity;

    private ActivityRequest request;

    private ActivityResponse response;

    @BeforeEach
    void setUp() {

        user = UserFactory.entity();

        project = ProjectFactory.entity(user);

        activity = ActivityFactory.entity(project);

        request = ActivityFactory.request(project.getId());

        response = ActivityFactory.response(activity);

    }

    @Test
    @DisplayName("Should create activity")
    void shouldCreateActivity() {

        // Arrange

        when(validator.validateProject(project.getId()))
                .thenReturn(project);

        when(mapper.toEntity(request))
                .thenReturn(activity);

        when(repository.save(activity))
                .thenReturn(activity);

        when(mapper.toResponse(activity))
                .thenReturn(response);

        // Act

        ActivityResponse result = service.create(request);

        // Assert

        assertSame(response, result);

        verify(repository).save(activity);

    }

    @Test
    @DisplayName("Should find all activities")
    void shouldFindAllActivities() {

        // Arrange

        when(repository.findAll())
                .thenReturn(List.of(activity));

        when(mapper.toResponseList(List.of(activity)))
                .thenReturn(List.of(response));

        // Act

        List<ActivityResponse> result = service.findAll();

        // Assert

        assertEquals(1, result.size());

        verify(repository).findAll();

    }

    @Test
    @DisplayName("Should find activity by id")
    void shouldFindActivityById() {

        // Arrange

        when(validator.validateActivity(activity.getId()))
                .thenReturn(activity);

        when(mapper.toResponse(activity))
                .thenReturn(response);

        // Act

        ActivityResponse result = service.findById(activity.getId());

        // Assert

        assertSame(response, result);

    }

    @Test
    @DisplayName("Should find activities by project")
    void shouldFindActivitiesByProject() {

        // Arrange

        when(repository.findByProjectId(project.getId()))
                .thenReturn(List.of(activity));

        when(mapper.toResponseList(List.of(activity)))
                .thenReturn(List.of(response));

        // Act

        List<ActivityResponse> result =
                service.findByProject(project.getId());

        // Assert

        assertEquals(1, result.size());

        verify(repository).findByProjectId(project.getId());

    }

    @Test
    @DisplayName("Should update activity")
    void shouldUpdateActivity() {

        // Arrange

        when(validator.validateActivity(activity.getId()))
                .thenReturn(activity);

        when(validator.validateProject(project.getId()))
                .thenReturn(project);

        doNothing().when(mapper)
                .updateEntity(request, activity);

        when(repository.save(activity))
                .thenReturn(activity);

        when(mapper.toResponse(activity))
                .thenReturn(response);

        // Act

        ActivityResponse result =
                service.update(activity.getId(), request);

        // Assert

        assertSame(response, result);

        verify(mapper).updateEntity(request, activity);

    }

    @Test
    @DisplayName("Should delete activity")
    void shouldDeleteActivity() {

        // Arrange

        when(validator.validateActivity(activity.getId()))
                .thenReturn(activity);

        // Act

        service.delete(activity.getId());

        // Assert

        verify(repository).delete(activity);

    }

}