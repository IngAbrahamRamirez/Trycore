package com.pruebatecnica.api.fixtures;

import java.math.BigDecimal;

import com.pruebatecnica.api.core.enums.CostStatus;
import com.pruebatecnica.api.core.enums.ScheduleStatus;
import com.pruebatecnica.api.dto.common.MetricsResponse;

public final class MetricsFactory {

    private MetricsFactory() {
    }

    /*
     * =========================
     * DEFAULT
     * =========================
     */

    public static MetricsResponse response() {

        MetricsResponse response = new MetricsResponse();

        response.setPv(new BigDecimal("400.00"));
        response.setEv(new BigDecimal("300.00"));
        response.setCv(new BigDecimal("50.00"));
        response.setSv(new BigDecimal("-100.00"));

        response.setCpi(new BigDecimal("1.20"));
        response.setSpi(new BigDecimal("0.75"));

        response.setEac(new BigDecimal("833.33"));
        response.setVac(new BigDecimal("166.67"));

        response.setCostStatus(CostStatus.UNDER_BUDGET);
        response.setScheduleStatus(ScheduleStatus.BEHIND_SCHEDULE);

        response.setCostInterpretation(
                "Project is under budget.");

        response.setScheduleInterpretation(
                "Project is behind schedule.");

        return response;

    }

    /*
     * =========================
     * UNDER BUDGET
     * =========================
     */

    public static MetricsResponse underBudget() {

        return response();

    }

    /*
     * =========================
     * OVER BUDGET
     * =========================
     */

    public static MetricsResponse overBudget() {

        MetricsResponse response = response();

        response.setCpi(new BigDecimal("0.80"));

        response.setCostStatus(
                CostStatus.OVER_BUDGET);

        response.setCostInterpretation(
                "Project is over budget.");

        return response;

    }

    /*
     * =========================
     * ON BUDGET
     * =========================
     */

    public static MetricsResponse onBudget() {

        MetricsResponse response = response();

        response.setCpi(BigDecimal.ONE);

        response.setCostStatus(
                CostStatus.ON_BUDGET);

        response.setCostInterpretation(
                "Project is on budget.");

        return response;

    }

    /*
     * =========================
     * AHEAD OF SCHEDULE
     * =========================
     */

    public static MetricsResponse aheadOfSchedule() {

        MetricsResponse response = response();

        response.setSpi(new BigDecimal("1.20"));

        response.setScheduleStatus(
                ScheduleStatus.AHEAD_OF_SCHEDULE);

        response.setScheduleInterpretation(
                "Project is ahead of schedule.");

        return response;

    }

    /*
     * =========================
     * ON SCHEDULE
     * =========================
     */

    public static MetricsResponse onSchedule() {

        MetricsResponse response = response();

        response.setSpi(BigDecimal.ONE);

        response.setScheduleStatus(
                ScheduleStatus.ON_SCHEDULE);

        response.setScheduleInterpretation(
                "Project is on schedule.");

        return response;

    }

}