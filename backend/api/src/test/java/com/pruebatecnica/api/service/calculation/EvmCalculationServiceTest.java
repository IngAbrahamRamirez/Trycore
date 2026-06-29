package com.pruebatecnica.api.service.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.pruebatecnica.api.dto.common.MetricsResponse;
import com.pruebatecnica.api.service.evm.EvmCalculationService;
import com.pruebatecnica.api.service.evm.EvmInputValidator;
import com.pruebatecnica.api.service.evm.EvmInput;

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

                new BigDecimal("1000"), // BAC
                new BigDecimal("40"),   // Planned %
                new BigDecimal("30"),   // Completed %
                new BigDecimal("250")   // AC

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

}