package com.pruebatecnica.api.service.evm;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.pruebatecnica.api.exception.InvalidEvmInputException;

class EvmInputValidatorTest {

    private EvmInputValidator validator;

    @BeforeEach
    void setUp() {

        validator = new EvmInputValidator();

    }

    @Test
    @DisplayName("Should accept valid input")
    void shouldAcceptValidInput() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("40"),
                new BigDecimal("30"),
                new BigDecimal("250")

        );

        assertDoesNotThrow(() -> validator.validate(input));

    }

    @Test
    @DisplayName("Should reject null input")
    void shouldRejectNullInput() {

        assertThrows(
                InvalidEvmInputException.class,
                () -> validator.validate(null)
        );

    }

    @Test
    @DisplayName("Should reject null BAC")
    void shouldRejectNullBac() {

        EvmInput input = new EvmInput(

                null,
                new BigDecimal("40"),
                new BigDecimal("30"),
                new BigDecimal("250")

        );

        assertThrows(
                InvalidEvmInputException.class,
                () -> validator.validate(input)
        );

    }

    @Test
    @DisplayName("Should reject negative BAC")
    void shouldRejectNegativeBac() {

        EvmInput input = new EvmInput(

                new BigDecimal("-1"),
                new BigDecimal("40"),
                new BigDecimal("30"),
                new BigDecimal("250")

        );

        assertThrows(
                InvalidEvmInputException.class,
                () -> validator.validate(input)
        );

    }

    @Test
    @DisplayName("Should reject planned percentage greater than 100")
    void shouldRejectPlannedPercentageGreaterThan100() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("101"),
                new BigDecimal("30"),
                new BigDecimal("250")

        );

        assertThrows(
                InvalidEvmInputException.class,
                () -> validator.validate(input)
        );

    }

    @Test
    @DisplayName("Should reject completed percentage greater than 100")
    void shouldRejectCompletedPercentageGreaterThan100() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("40"),
                new BigDecimal("101"),
                new BigDecimal("250")

        );

        assertThrows(
                InvalidEvmInputException.class,
                () -> validator.validate(input)
        );

    }

    @Test
    @DisplayName("Should reject negative actual cost")
    void shouldRejectNegativeActualCost() {

        EvmInput input = new EvmInput(

                new BigDecimal("1000"),
                new BigDecimal("40"),
                new BigDecimal("30"),
                new BigDecimal("-1")

        );

        assertThrows(
                InvalidEvmInputException.class,
                () -> validator.validate(input)
        );

    }

}