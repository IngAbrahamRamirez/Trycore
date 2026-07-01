package com.pruebatecnica.api.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pruebatecnica.api.domain.audit.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "activities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity extends AuditableEntity {

    @Column(nullable = false, length = 200)
    private String name;

    @Column(
            name = "budget_at_completion",
            nullable = false,
            precision = 14,
            scale = 2
    )
    private BigDecimal budgetAtCompletion;

    @Column(
            name = "planned_percentage",
            nullable = false,
            precision = 5,
            scale = 2
    )
    private BigDecimal plannedPercentage;

    @Column(
            name = "actual_percentage",
            nullable = false,
            precision = 5,
            scale = 2
    )
    private BigDecimal actualPercentage;

    @Column(
            name = "actual_cost",
            nullable = false,
            precision = 14,
            scale = 2
    )
    private BigDecimal actualCost;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

}