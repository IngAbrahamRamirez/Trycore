package com.pruebatecnica.api.service.activity;

import java.util.UUID;

import com.pruebatecnica.api.dto.common.MetricsResponse;

public interface ActivityMetricsService {

    MetricsResponse calculate(UUID activityId);

}