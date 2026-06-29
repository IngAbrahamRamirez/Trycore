package com.pruebatecnica.api.service.activity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

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
import com.pruebatecnica.api.exception.ResourceNotFoundException;
import com.pruebatecnica.api.fixtures.ActivityFactory;
import com.pruebatecnica.api.fixtures.ProjectFactory;
import com.pruebatecnica.api.fixtures.UserFactory;
import com.pruebatecnica.api.repository.ActivityRepository;
import com.pruebatecnica.api.repository.ProjectRepository;

@ExtendWith(MockitoExtension.class)
class ActivityValidatorTest {

    @Mock
    private ActivityRepository activityRepository;

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ActivityValidator validator;

    private User user;

    private Project project;

    private Activity activity;

    @BeforeEach
    void setUp() {

        user = UserFactory.entity();

        project = ProjectFactory.entity(user);

        activity = ActivityFactory.entity(project);

    }

    @Test
    @DisplayName("Should return existing activity")
    void shouldReturnExistingActivity() {

        when(activityRepository.findById(activity.getId()))
                .thenReturn(Optional.of(activity));

        Activity result = validator.validateActivity(activity.getId());

        assertEquals(activity, result);

    }

    @Test
    @DisplayName("Should throw exception when activity does not exist")
    void shouldThrowWhenActivityNotFound() {

        when(activityRepository.findById(activity.getId()))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> validator.validateActivity(activity.getId()));

    }

    @Test
    @DisplayName("Should return existing project")
    void shouldReturnExistingProject() {

        when(projectRepository.findById(project.getId()))
                .thenReturn(Optional.of(project));

        Project result = validator.validateProject(project.getId());

        assertEquals(project, result);

    }

    @Test
    @DisplayName("Should throw exception when project does not exist")
    void shouldThrowWhenProjectNotFound() {

        when(projectRepository.findById(project.getId()))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> validator.validateProject(project.getId()));

    }

}