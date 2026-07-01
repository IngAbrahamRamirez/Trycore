package com.pruebatecnica.api.service.activity;

import java.util.List;
import java.util.UUID;

import com.pruebatecnica.api.dto.activity.ActivityRequest;
import com.pruebatecnica.api.dto.activity.ActivityResponse;

public interface ActivityService {

    ActivityResponse create(ActivityRequest request);

    List<ActivityResponse> findAll();

    ActivityResponse findById(UUID id);

    List<ActivityResponse> findByProject(UUID projectId);

    ActivityResponse update(UUID id, ActivityRequest request);

    void delete(UUID id);

}