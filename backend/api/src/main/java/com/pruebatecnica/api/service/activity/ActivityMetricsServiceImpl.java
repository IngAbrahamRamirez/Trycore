package com.pruebatecnica.api.service.activity;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.api.domain.entity.Activity;
import com.pruebatecnica.api.dto.common.MetricsResponse;
import com.pruebatecnica.api.service.evm.EvmCalculationService;
import com.pruebatecnica.api.service.evm.EvmInput;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ActivityMetricsServiceImpl implements ActivityMetricsService {

    private final ActivityValidator activityValidator;
    private final EvmCalculationService evmCalculationService;

    @Override
    public MetricsResponse calculate(UUID activityId) {

        Activity activity = activityValidator.validateActivity(activityId);

        return evmCalculationService.calculate(

                new EvmInput(
                        activity.getBudgetAtCompletion(),
                        activity.getPlannedPercentage(),
                        activity.getActualPercentage(),
                        activity.getActualCost()
                )

        );

    }

}