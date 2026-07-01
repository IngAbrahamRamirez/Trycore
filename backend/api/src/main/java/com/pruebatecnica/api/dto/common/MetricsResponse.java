package com.pruebatecnica.api.dto.common;

import java.math.BigDecimal;

import com.pruebatecnica.api.core.enums.CostStatus;
import com.pruebatecnica.api.core.enums.ScheduleStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Earned Value Management metrics.")
public class MetricsResponse {
    
    @Schema(description = "The planned value of the project", example = "10000.00")
    private BigDecimal pv;

    @Schema(description = "The earned value of the project", example = "8000.00")
    private BigDecimal ev;

    @Schema(description = "The cost variance of the project", example = "2000.00")
    private BigDecimal cv;

    @Schema(description = "The schedule variance of the project", example = "1000.00")
    private BigDecimal sv;

    @Schema(description = "The cost performance index of the project", example = "0.80")
    private BigDecimal cpi;

    @Schema(description = "The schedule performance index of the project", example = "0.80")
    private BigDecimal spi;

    @Schema(description = "The estimate at completion of the project", example = "12500.00")
    private BigDecimal eac;

    @Schema(description = "The variance at completion of the project", example = "2500.00")
    private BigDecimal vac;

    @Schema(description = "The cost status of the project")
    private CostStatus costStatus;

    @Schema(description = "The schedule status of the project")
    private ScheduleStatus scheduleStatus;

    @Schema(description = "The interpretation of the cost status")
    private String costInterpretation;

    @Schema(description = "The interpretation of the schedule status")
    private String scheduleInterpretation;

}