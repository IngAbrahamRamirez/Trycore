package com.pruebatecnica.api.fixtures;

import java.util.UUID;

import com.pruebatecnica.api.core.enums.ProjectStatus;
import com.pruebatecnica.api.domain.entity.Project;
import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.dto.project.ProjectRequest;
import com.pruebatecnica.api.dto.project.ProjectResponse;

public final class ProjectFactory {

    private ProjectFactory() {
    }

    /*
     * =========================
     * ENTITY
     * =========================
     */

    public static Project entity() {

        return entity(UserFactory.entity());

    }

    public static Project entity(User user) {

        Project project = Project.builder()
                .name(TestConstants.PROJECT_NAME)
                .description(TestConstants.PROJECT_DESCRIPTION)
                .startDate(TestConstants.START_DATE)
                .endDate(TestConstants.END_DATE)
                .status(ProjectStatus.PLANNED)
                .user(user)
                .build();

        project.setId(TestConstants.PROJECT_ID);

        return project;

    }

    /*
     * =========================
     * REQUEST
     * =========================
     */

    public static ProjectRequest request() {

        return request(TestConstants.USER_ID);

    }

    public static ProjectRequest request(UUID userId) {

        ProjectRequest request = new ProjectRequest();

        request.setUserId(userId);
        request.setName(TestConstants.PROJECT_NAME);
        request.setDescription(TestConstants.PROJECT_DESCRIPTION);
        request.setStartDate(TestConstants.START_DATE);
        request.setEndDate(TestConstants.END_DATE);
        request.setStatus(ProjectStatus.PLANNED);

        return request;

    }

    /*
     * =========================
     * RESPONSE
     * =========================
     */

    public static ProjectResponse response() {

        return response(entity());

    }

    public static ProjectResponse response(Project project) {

        ProjectResponse response = new ProjectResponse();

        response.setId(project.getId());
        response.setName(project.getName());
        response.setDescription(project.getDescription());
        response.setStartDate(project.getStartDate());
        response.setEndDate(project.getEndDate());
        response.setStatus(project.getStatus());

        return response;

    }

}