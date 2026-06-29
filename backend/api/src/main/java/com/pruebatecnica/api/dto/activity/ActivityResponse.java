package com.pruebatecnica.api.dto.activity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Response containing activity details.")
public class ActivityResponse {

    private UUID id;

    private UUID projectId;

    private String name;

    private BigDecimal budgetAtCompletion;

    private BigDecimal plannedPercentage;

    private BigDecimal actualPercentage;

    private BigDecimal actualCost;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}