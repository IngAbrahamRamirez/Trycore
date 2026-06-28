package com.pruebatecnica.api.domain.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pruebatecnica.api.domain.audit.AuditableEntity;

@Entity
@Table(name = "activities")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Activity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String name;

    private BigDecimal bac;

    private BigDecimal plannedPercentage;

    private BigDecimal completedPercentage;

    private BigDecimal actualCost;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id",nullable = false)
    private Project project;
}