package com.pruebatecnica.api.service.evm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.pruebatecnica.api.core.enums.CostStatus;
import com.pruebatecnica.api.core.enums.ScheduleStatus;
import com.pruebatecnica.api.dto.common.MetricsResponse;

class EvmCalculationServiceTest {

    private EvmCalculationService service;

    @BeforeEach
    void setUp() {

        service = new EvmCalculationService(new EvmInputValidator());

    }

    @Test
    @DisplayName("Should calculate all EVM metrics correctly")
    void shouldCalculateAllMetrics() {

        // Arrange

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("40"),
                new BigDecimal("30"),
                new BigDecimal("250")

        );

        // Act

        MetricsResponse result = service.calculate(input);

        // Assert

        assertEquals(new BigDecimal("400.00"), result.getPv());
        assertEquals(new BigDecimal("300.00"), result.getEv());
        assertEquals(new BigDecimal("50.00"), result.getCv());
        assertEquals(new BigDecimal("-100.00"), result.getSv());
        assertEquals(new BigDecimal("1.20"), result.getCpi());
        assertEquals(new BigDecimal("0.75"), result.getSpi());
        assertEquals(new BigDecimal("833.33"), result.getEac());
        assertEquals(new BigDecimal("166.67"), result.getVac());

    }

    @Test
    @DisplayName("Should return UNDER_BUDGET when CPI is greater than one")
    void shouldReturnUnderBudget() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("50"),
                new BigDecimal("50"),
                new BigDecimal("300")

        );

        MetricsResponse result = service.calculate(input);

        assertEquals(CostStatus.UNDER_BUDGET, result.getCostStatus());

    }

    @Test
    @DisplayName("Should return OVER_BUDGET when CPI is lower than one")
    void shouldReturnOverBudget() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("50"),
                new BigDecimal("50"),
                new BigDecimal("700")

        );

        MetricsResponse result = service.calculate(input);

        assertEquals(CostStatus.OVER_BUDGET, result.getCostStatus());

    }

    @Test
    @DisplayName("Should return ON_BUDGET when EV equals AC")
    void shouldReturnOnBudget() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("50"),
                new BigDecimal("50"),
                new BigDecimal("500")

        );

        MetricsResponse result = service.calculate(input);

        assertEquals(CostStatus.ON_BUDGET, result.getCostStatus());

    }

    @Test
    @DisplayName("Should return AHEAD_OF_SCHEDULE when SPI is greater than one")
    void shouldReturnAheadOfSchedule() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("20"),
                new BigDecimal("50"),
                new BigDecimal("500")

        );

        MetricsResponse result = service.calculate(input);

        assertEquals(ScheduleStatus.AHEAD_OF_SCHEDULE, result.getScheduleStatus());

    }

    @Test
    @DisplayName("Should return BEHIND_SCHEDULE when SPI is lower than one")
    void shouldReturnBehindSchedule() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("70"),
                new BigDecimal("30"),
                new BigDecimal("300")

        );

        MetricsResponse result = service.calculate(input);

        assertEquals(ScheduleStatus.BEHIND_SCHEDULE, result.getScheduleStatus());

    }

    @Test
    @DisplayName("Should return ON_SCHEDULE when SPI equals one")
    void shouldReturnOnSchedule() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("50"),
                new BigDecimal("50"),
                new BigDecimal("400")

        );

        MetricsResponse result = service.calculate(input);

        assertEquals(ScheduleStatus.ON_SCHEDULE, result.getScheduleStatus());

    }

    @Test
    @DisplayName("Should return zero indexes when dividing by zero")
    void shouldReturnZeroWhenDividingByZero() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                BigDecimal.ZERO

        );

        MetricsResponse result = service.calculate(input);

        assertEquals(0, result.getCpi().compareTo(BigDecimal.ZERO));
        assertEquals(0, result.getSpi().compareTo(BigDecimal.ZERO));

    }

    @Test
    @DisplayName("Should calculate metrics using decimal values")
    void shouldCalculateUsingDecimalValues() {

        EvmInput input = new EvmInput(

                new BigDecimal("15342.87"),
                new BigDecimal("37.45"),
                new BigDecimal("31.82"),
                new BigDecimal("4321.89")

        );

        MetricsResponse result = service.calculate(input);

        assertEquals(2, result.getPv().scale());
        assertEquals(2, result.getEv().scale());
        assertEquals(2, result.getCpi().scale());
        assertEquals(2, result.getSpi().scale());

    }

    @Test
    @DisplayName("Should return proper textual interpretations")
    void shouldReturnCorrectInterpretations() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("20"),
                new BigDecimal("50"),
                new BigDecimal("300")

        );

        MetricsResponse result = service.calculate(input);

        assertEquals("Project is under budget.", result.getCostInterpretation());
        assertEquals("Project is ahead of schedule.", result.getScheduleInterpretation());

    }

}