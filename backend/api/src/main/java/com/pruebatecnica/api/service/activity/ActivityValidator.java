package com.pruebatecnica.api.service.activity;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.pruebatecnica.api.domain.entity.Activity;
import com.pruebatecnica.api.domain.entity.Project;
import com.pruebatecnica.api.exception.ResourceNotFoundException;
import com.pruebatecnica.api.repository.ActivityRepository;
import com.pruebatecnica.api.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ActivityValidator {

    private final ActivityRepository activityRepository;
    private final ProjectRepository projectRepository;

    public Activity validateExists(UUID id) {

        return activityRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Activity not found."));
    }

    public Project validateProject(UUID id) {

        return projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found."));
    }

}