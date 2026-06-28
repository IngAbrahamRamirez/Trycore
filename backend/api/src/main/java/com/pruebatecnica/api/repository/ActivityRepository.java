package com.pruebatecnica.api.repository;

import com.pruebatecnica.api.domain.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {

    List<Activity> findByProjectId(UUID projectId);

}