package com.pruebatecnica.api.dto.common;

import java.math.BigDecimal;

import com.pruebatecnica.api.core.enums.CostStatus;
import com.pruebatecnica.api.core.enums.ScheduleStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetricsResponse {

    private BigDecimal pv;

    private BigDecimal ev;

    private BigDecimal cv;

    private BigDecimal sv;

    private BigDecimal cpi;

    private BigDecimal spi;

    private BigDecimal eac;

    private BigDecimal vac;

    private CostStatus costStatus;

    private ScheduleStatus scheduleStatus;

    private String costInterpretation;

    private String scheduleInterpretation;

}