package com.pruebatecnica.api.service.evm;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.pruebatecnica.api.exception.InvalidEvmInputException;

@Component
public class EvmInputValidator {

    private static final BigDecimal ZERO = BigDecimal.ZERO;
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

    public void validate(EvmInput input) {

        if (input == null) {
            throw new InvalidEvmInputException("EVM input cannot be null.");
        }

        validatePositive(input.bac(), "BAC");

        validatePercentage(input.plannedPercentage(), "Planned percentage");

        validatePercentage(input.completedPercentage(), "Completed percentage");

        validatePositive(input.actualCost(), "Actual Cost");
    }

    private void validatePositive(BigDecimal value, String field) {

        if (value == null) {
            throw new InvalidEvmInputException(field + " cannot be null.");
        }

        if (value.compareTo(ZERO) < 0) {
            throw new InvalidEvmInputException(field + " cannot be negative.");
        }
    }

    private void validatePercentage(BigDecimal value, String field) {

        if (value == null) {
            throw new InvalidEvmInputException(field + " cannot be null.");
        }

        if (value.compareTo(ZERO) < 0 ||
                value.compareTo(HUNDRED) > 0) {

            throw new InvalidEvmInputException(
                    field + " must be between 0 and 100.");
        }
    }

}