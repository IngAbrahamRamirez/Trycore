package com.pruebatecnica.api.service.evm;

import java.util.UUID;

import com.pruebatecnica.api.dto.common.MetricsResponse;

public interface ProjectMetricsService {

    MetricsResponse calculate(UUID projectId);

}