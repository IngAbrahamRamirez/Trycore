package com.pruebatecnica.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebatecnica.api.domain.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {

    List<Activity> findByProjectId(UUID projectId);

}