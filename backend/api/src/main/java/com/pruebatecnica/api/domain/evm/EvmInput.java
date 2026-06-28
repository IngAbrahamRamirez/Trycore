package com.pruebatecnica.api.domain.evm;

import java.math.BigDecimal;

public record EvmInput(

        BigDecimal bac,

        BigDecimal plannedPercentage,

        BigDecimal completedPercentage,

        BigDecimal actualCost

) {}