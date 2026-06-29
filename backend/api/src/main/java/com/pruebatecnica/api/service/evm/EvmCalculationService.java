package com.pruebatecnica.api.service.evm;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.pruebatecnica.api.core.enums.CostStatus;
import com.pruebatecnica.api.core.enums.ScheduleStatus;
import com.pruebatecnica.api.dto.common.MetricsResponse;

@Service
public class EvmCalculationService {

    private final EvmInputValidator validator;

    public EvmCalculationService(EvmInputValidator validator) {
        this.validator = validator;
    }

    public MetricsResponse calculate(EvmInput input) {

        validator.validate(input);

        BigDecimal pv = calculatePV(input.bac(), input.plannedPercentage());
        BigDecimal ev = calculateEV(input.bac(), input.completedPercentage());
        BigDecimal ac = input.actualCost();

        BigDecimal cv = calculateCV(ev, ac);
        BigDecimal sv = calculateSV(ev, pv);
        BigDecimal cpi = calculateCPI(ev, ac);
        BigDecimal spi = calculateSPI(ev, pv);
        BigDecimal eac = calculateEAC(input.bac(), cpi);
        BigDecimal vac = calculateVAC(input.bac(), eac);

        CostStatus costStatus = getCostStatus(cpi);
        ScheduleStatus scheduleStatus = getScheduleStatus(spi);

        return MetricsResponse.builder()
        .pv(pv)
        .ev(ev)
        .cv(cv)
        .sv(sv)
        .cpi(cpi)
        .spi(spi)
        .eac(eac)
        .vac(vac)
        .costStatus(costStatus)
        .scheduleStatus(scheduleStatus)
        .costInterpretation(getCostInterpretation(costStatus))
        .scheduleInterpretation(getScheduleInterpretation(scheduleStatus))
        .build();
    }
    
    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING = RoundingMode.HALF_UP;
    // Repetitive code for division and percentage calculations, which are used in
    // multiple EVM calculations

    private BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {

    if (divisor == null || divisor.compareTo(BigDecimal.ZERO) == 0) {
        return BigDecimal.ZERO.setScale(SCALE, RoundingMode.HALF_UP);
    }

    return dividend.divide(divisor, SCALE, ROUNDING).setScale(SCALE, RoundingMode.HALF_UP);
}

    private BigDecimal percentage(BigDecimal value) {

        return value.divide(
                BigDecimal.valueOf(100),
                SCALE,
                ROUNDING);
    }

    // EVM calculations

    // Planned Value (PV) = BAC * Planned Percentage

    private BigDecimal calculatePV(
            BigDecimal bac,
            BigDecimal plannedPercentage) {

        return bac.multiply(percentage(plannedPercentage))
                .setScale(SCALE, ROUNDING);
    }

    // Earned Value (EV) = BAC * Completed Percentage

    private BigDecimal calculateEV(
            BigDecimal bac,
            BigDecimal completedPercentage) {

        return bac.multiply(percentage(completedPercentage))
                .setScale(SCALE, ROUNDING);
    }

    // Cost Variance (CV) = EV - AC

    private BigDecimal calculateCV(
            BigDecimal ev,
            BigDecimal actualCost) {

        return ev.subtract(actualCost);
    }

    // Schedule Variance (SV) = EV - PV

    private BigDecimal calculateSV(
            BigDecimal ev,
            BigDecimal pv) {

        return ev.subtract(pv);
    }

    // Cost Performance Index (CPI) = EV / AC

    private BigDecimal calculateCPI(
            BigDecimal ev,
            BigDecimal actualCost) {

        return divide(ev, actualCost);
    }

    // Schedule Performance Index (SPI) = EV / PV

    private BigDecimal calculateSPI(
            BigDecimal ev,
            BigDecimal pv) {

        return divide(ev, pv);
    }

    // Estimate at Completion (EAC) = BAC / CPI

    private BigDecimal calculateEAC(
            BigDecimal bac,
            BigDecimal cpi) {

        return divide(bac, cpi);
    }

    // Variance at Completion (VAC) = BAC - EAC

    private BigDecimal calculateVAC(
            BigDecimal bac,
            BigDecimal eac) {

        return bac.subtract(eac);
    }

    // Cost Status based on CPI (interpretation of CPI values)

    private CostStatus getCostStatus(BigDecimal cpi) {

        int comparison = cpi.compareTo(BigDecimal.ONE);

        if (comparison > 0)
            return CostStatus.UNDER_BUDGET;

        if (comparison < 0)
            return CostStatus.OVER_BUDGET;

        return CostStatus.ON_BUDGET;
    }

    private String getCostInterpretation(CostStatus status) {

        return switch (status) {

            case UNDER_BUDGET ->
                "Project is under budget.";

            case ON_BUDGET ->
                "Project is on budget.";

            case OVER_BUDGET ->
                "Project is over budget.";
        };
    }

    // Schedule Status based on SPI (interpretation of SPI values)

    private ScheduleStatus getScheduleStatus(BigDecimal spi) {

        int comparison = spi.compareTo(BigDecimal.ONE);

        if (comparison > 0)
            return ScheduleStatus.AHEAD_OF_SCHEDULE;

        if (comparison < 0)
            return ScheduleStatus.BEHIND_SCHEDULE;

        return ScheduleStatus.ON_SCHEDULE;
    }

    private String getScheduleInterpretation(ScheduleStatus status) {

        return switch (status) {

            case AHEAD_OF_SCHEDULE ->
                "Project is ahead of schedule.";

            case ON_SCHEDULE ->
                "Project is on schedule.";

            case BEHIND_SCHEDULE ->
                "Project is behind schedule.";
        };
    }
}