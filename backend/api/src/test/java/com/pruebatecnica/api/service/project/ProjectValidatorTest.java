package com.pruebatecnica.api.service.project;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pruebatecnica.api.domain.entity.Project;
import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.exception.ResourceNotFoundException;
import com.pruebatecnica.api.fixtures.ProjectFactory;
import com.pruebatecnica.api.fixtures.UserFactory;
import com.pruebatecnica.api.repository.ProjectRepository;
import com.pruebatecnica.api.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class ProjectValidatorTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProjectValidator validator;

    private Project project;
    private User user;

    @BeforeEach
    void setUp() {

        user = UserFactory.entity();

        project = ProjectFactory.entity(user);

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

    @Test
    @DisplayName("Should return existing user")
    void shouldReturnExistingUser() {

        when(userRepository.findById(user.getId()))
                .thenReturn(Optional.of(user));

        User result = validator.validateUser(user.getId());

        assertEquals(user, result);

    }

    @Test
    @DisplayName("Should throw exception when user does not exist")
    void shouldThrowWhenUserNotFound() {

        when(userRepository.findById(user.getId()))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> validator.validateUser(user.getId()));

    }

}