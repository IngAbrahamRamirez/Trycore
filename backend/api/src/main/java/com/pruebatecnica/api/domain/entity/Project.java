package com.pruebatecnica.api.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import com.pruebatecnica.api.core.enums.ProjectStatus;
import com.pruebatecnica.api.domain.audit.AuditableEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project extends AuditableEntity {

    @JsonManagedReference
    @OneToMany(mappedBy = "project")
    private List<Activity> activities;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
}