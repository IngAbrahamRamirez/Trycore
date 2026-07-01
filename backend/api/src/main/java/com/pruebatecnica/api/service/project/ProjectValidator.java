package com.pruebatecnica.api.service.project;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.pruebatecnica.api.domain.entity.Project;
import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.exception.ResourceNotFoundException;
import com.pruebatecnica.api.repository.ProjectRepository;
import com.pruebatecnica.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProjectValidator {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public Project validateProject(UUID id) {

        return projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found."));
    }

    public User validateUser(UUID id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found."));
    }

}