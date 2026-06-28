package com.pruebatecnica.api.domain.evm;

import java.math.BigDecimal;

import com.pruebatecnica.api.domain.enums.CostStatus;
import com.pruebatecnica.api.domain.enums.ScheduleStatus;

public record EvmResult(

        BigDecimal pv,

        BigDecimal ev,

        BigDecimal cv,

        BigDecimal sv,

        BigDecimal cpi,

        BigDecimal spi,

        BigDecimal eac,

        BigDecimal vac,

        CostStatus costStatus,

        ScheduleStatus scheduleStatus,

        String costInterpretation,
        
        String scheduleInterpretation

) {
}