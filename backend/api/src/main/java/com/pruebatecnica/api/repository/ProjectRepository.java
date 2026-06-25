package com.pruebatecnica.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatecnica.api.entity.Project;

public interface ProjectRepository
        extends JpaRepository<Project, UUID> {
}