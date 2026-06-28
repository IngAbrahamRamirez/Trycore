package com.pruebatecnica.api.service.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.pruebatecnica.api.domain.evm.EvmInput;
import com.pruebatecnica.api.domain.evm.EvmResult;
import com.pruebatecnica.api.service.evm.EvmCalculationService;

class EvmCalculationServiceTest {

    private EvmCalculationService service;

    @BeforeEach
    void setUp() {
        service = new EvmCalculationService(null);
    }

    @Test
    @DisplayName("Should calculate all EVM metrics correctly")
    void shouldCalculateAllMetrics() {

        // Arrange

        EvmInput input = new EvmInput(

                new BigDecimal("1000"), // BAC

                new BigDecimal("40"), // Planned %

                new BigDecimal("30"), // Completed %

                new BigDecimal("250") // AC

        );

        // Act

        EvmResult result = service.calculate(input);

        // Assert

        assertEquals(new BigDecimal("400.00"), result.pv());

        assertEquals(new BigDecimal("300.00"), result.ev());

        assertEquals(new BigDecimal("50.00"), result.cv());

        assertEquals(new BigDecimal("-100.00"), result.sv());

        assertEquals(new BigDecimal("1.20"), result.cpi());

        assertEquals(new BigDecimal("0.75"), result.spi());

        assertEquals(new BigDecimal("833.33"), result.eac());

        assertEquals(new BigDecimal("166.67"), result.vac());

    }

}