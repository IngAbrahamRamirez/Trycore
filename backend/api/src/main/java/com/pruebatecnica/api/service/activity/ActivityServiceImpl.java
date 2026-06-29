package com.pruebatecnica.api.service.activity;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.api.domain.entity.Activity;
import com.pruebatecnica.api.domain.entity.Project;
import com.pruebatecnica.api.dto.activity.ActivityRequest;
import com.pruebatecnica.api.dto.activity.ActivityResponse;
import com.pruebatecnica.api.mapper.ActivityMapper;
import com.pruebatecnica.api.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;
    private final ActivityValidator activityValidator;

    @Override
    public ActivityResponse create(ActivityRequest request) {

        Project project = activityValidator.validateProject(request.getProjectId());

        Activity activity = activityMapper.toEntity(request);
        activity.setProject(project);

        activity = activityRepository.save(activity);

        return activityMapper.toResponse(activity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityResponse> findAll() {
        return activityMapper.toResponseList(activityRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ActivityResponse findById(UUID id) {
        return activityMapper.toResponse(activityValidator.validateExists(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityResponse> findByProject(UUID projectId) {

        activityValidator.validateProject(projectId);

        return activityMapper.toResponseList(
                activityRepository.findByProjectId(projectId));
    }

    @Override
    public ActivityResponse update(UUID id, ActivityRequest request) {

        Activity activity = activityValidator.validateExists(id);

        Project project = activityValidator.validateProject(request.getProjectId());

        activityMapper.updateEntity(request, activity);
        activity.setProject(project);

        activity = activityRepository.save(activity);

        return activityMapper.toResponse(activity);
    }

    @Override
    public void delete(UUID id) {

        Activity activity = activityValidator.validateExists(id);

        activityRepository.delete(activity);
    }

}