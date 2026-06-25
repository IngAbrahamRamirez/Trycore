package com.pruebatecnica.api.service.calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.pruebatecnica.api.domain.enums.CostStatus;
import com.pruebatecnica.api.domain.enums.ScheduleStatus;

@Service
public class EvmCalculationService {

    private static final int SCALE = 2;

//Repetitive code for division and percentage calculations, which are used in multiple EVM calculations

private BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {

    if (divisor.compareTo(BigDecimal.ZERO) == 0) {
        return BigDecimal.ZERO;
    }

    return dividend.divide(divisor, SCALE, RoundingMode.HALF_UP);
}

private BigDecimal percentage(BigDecimal value) {

    return value.divide(
            BigDecimal.valueOf(100),
            SCALE,
            RoundingMode.HALF_UP);
}

//EVM calculations

//Planned Value (PV) = BAC * Planned Percentage

public BigDecimal calculatePV(
        BigDecimal bac,
        BigDecimal plannedPercentage) {

    return bac.multiply(percentage(plannedPercentage))
            .setScale(SCALE, RoundingMode.HALF_UP);
}

//Earned Value (EV) = BAC * Completed Percentage

public BigDecimal calculateEV(
        BigDecimal bac,
        BigDecimal completedPercentage) {

    return bac.multiply(percentage(completedPercentage))
            .setScale(SCALE, RoundingMode.HALF_UP);
}

//Cost Variance (CV) = EV - AC

public BigDecimal calculateCV(
        BigDecimal ev,
        BigDecimal actualCost) {

    return ev.subtract(actualCost);
}

//Schedule Variance (SV) = EV - PV

public BigDecimal calculateSV(
        BigDecimal ev,
        BigDecimal pv) {

    return ev.subtract(pv);
}

//Cost Performance Index (CPI) = EV / AC

public BigDecimal calculateCPI(
        BigDecimal ev,
        BigDecimal actualCost) {

    return divide(ev, actualCost);
}

//Schedule Performance Index (SPI) = EV / PV

public BigDecimal calculateSPI(
        BigDecimal ev,
        BigDecimal pv) {

    return divide(ev, pv);
}

//Estimate at Completion (EAC) = BAC / CPI

public BigDecimal calculateEAC(
        BigDecimal bac,
        BigDecimal cpi) {

    return divide(bac, cpi);
}

//Variance at Completion (VAC) = BAC - EAC

public BigDecimal calculateVAC(
        BigDecimal bac,
        BigDecimal eac) {

    return bac.subtract(eac);
}

//Cost Status based on CPI (interpretation of CPI values)

public CostStatus getCostStatus(BigDecimal cpi) {

    int comparison = cpi.compareTo(BigDecimal.ONE);

    if (comparison > 0)
        return CostStatus.UNDER_BUDGET;

    if (comparison < 0)
        return CostStatus.OVER_BUDGET;

    return CostStatus.ON_BUDGET;
}

//Schedule Status based on SPI (interpretation of SPI values)

public ScheduleStatus getScheduleStatus(BigDecimal spi) {

    int comparison = spi.compareTo(BigDecimal.ONE);

    if (comparison > 0)
        return ScheduleStatus.AHEAD_OF_SCHEDULE;

    if (comparison < 0)
        return ScheduleStatus.BEHIND_SCHEDULE;

    return ScheduleStatus.ON_SCHEDULE;
}
}