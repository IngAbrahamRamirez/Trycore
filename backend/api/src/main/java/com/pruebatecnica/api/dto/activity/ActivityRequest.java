package com.pruebatecnica.api.dto.activity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Schema(description = "Request used to create or update activities.")
public class ActivityRequest {

    @NotBlank
    @Size(max = 200)
    @Schema(description = "The name of the activity", example = "Design Phase")
    private String name;

    @NotNull
    @Schema(description = "The ID of the project to which the activity belongs", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID projectId;

    @NotNull
    @Schema(description = "The budget at completion for the activity", example = "10000.00")
    @DecimalMin("0.01")
    @Digits(integer = 12, fraction = 2)
    private BigDecimal budgetAtCompletion;

    @NotNull
    @Schema(description = "The planned percentage for the activity", example = "50.00")
    @DecimalMin("0.00")
    @DecimalMax("100.00")
    @Digits(integer = 3, fraction = 2)
    private BigDecimal plannedPercentage;

    @NotNull
    @Schema(description = "The actual percentage for the activity", example = "60.00")
    @DecimalMin("0.00")
    @DecimalMax("100.00")
    @Digits(integer = 3, fraction = 2)
    private BigDecimal actualPercentage;

    @NotNull
    @Schema(description = "The actual cost for the activity", example = "6000.00")
    @DecimalMin("0.00")
    @Digits(integer = 12, fraction = 2)
    private BigDecimal actualCost;

}