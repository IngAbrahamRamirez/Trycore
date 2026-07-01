package com.pruebatecnica.api.service.evm;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.api.domain.entity.Activity;
import com.pruebatecnica.api.domain.entity.Project;
import com.pruebatecnica.api.dto.common.MetricsResponse;
import com.pruebatecnica.api.exception.ResourceNotFoundException;
import com.pruebatecnica.api.repository.ActivityRepository;
import com.pruebatecnica.api.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectMetricsServiceImpl implements ProjectMetricsService {

    private final ProjectRepository projectRepository;
    private final ActivityRepository activityRepository;
    private final EvmCalculationService evmCalculationService;

    @Override
    public MetricsResponse calculate(UUID projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found"));

        List<Activity> activities =
                activityRepository.findByProjectId(project.getId());

        if (activities.isEmpty()) {
            throw new ResourceNotFoundException(
                    "Project has no activities.");
        }

        BigDecimal bac = BigDecimal.ZERO;
        BigDecimal pv = BigDecimal.ZERO;
        BigDecimal ev = BigDecimal.ZERO;
        BigDecimal ac = BigDecimal.ZERO;

        for (Activity activity : activities) {

            bac = bac.add(activity.getBudgetAtCompletion());

            pv = pv.add(
                    activity.getBudgetAtCompletion()
                            .multiply(activity.getPlannedPercentage())
                            .divide(BigDecimal.valueOf(100)));

            ev = ev.add(
                    activity.getBudgetAtCompletion()
                            .multiply(activity.getActualPercentage())
                            .divide(BigDecimal.valueOf(100)));

            ac = ac.add(activity.getActualCost());
        }

        BigDecimal plannedPercentage =
                pv.multiply(BigDecimal.valueOf(100))
                        .divide(bac, 2, java.math.RoundingMode.HALF_UP);

        BigDecimal completedPercentage =
                ev.multiply(BigDecimal.valueOf(100))
                        .divide(bac, 2, java.math.RoundingMode.HALF_UP);

        EvmInput input = new EvmInput(
                bac,
                plannedPercentage,
                completedPercentage,
                ac
        );

        return evmCalculationService.calculate(input);
    }

}