package com.pruebatecnica.api.fixtures;

import java.util.UUID;

import com.pruebatecnica.api.domain.entity.Activity;
import com.pruebatecnica.api.domain.entity.Project;
import com.pruebatecnica.api.dto.activity.ActivityRequest;
import com.pruebatecnica.api.dto.activity.ActivityResponse;

public final class ActivityFactory {

    private ActivityFactory() {
    }

    /*
     * =========================
     * ENTITY
     * =========================
     */

    public static Activity entity() {

        return entity(ProjectFactory.entity());

    }

    public static Activity entity(Project project) {

        Activity activity = Activity.builder()
                .name(TestConstants.ACTIVITY_NAME)
                .budgetAtCompletion(TestConstants.BAC)
                .plannedPercentage(TestConstants.PLANNED_PERCENTAGE)
                .actualPercentage(TestConstants.ACTUAL_PERCENTAGE)
                .actualCost(TestConstants.ACTUAL_COST)
                .project(project)
                .build();

        activity.setId(TestConstants.ACTIVITY_ID);

        return activity;

    }

    /*
     * =========================
     * REQUEST
     * =========================
     */

    public static ActivityRequest request() {

        return request(TestConstants.PROJECT_ID);

    }

    public static ActivityRequest request(UUID projectId) {

        ActivityRequest request = new ActivityRequest();

        request.setProjectId(projectId);
        request.setName(TestConstants.ACTIVITY_NAME);
        request.setBudgetAtCompletion(TestConstants.BAC);
        request.setPlannedPercentage(TestConstants.PLANNED_PERCENTAGE);
        request.setActualPercentage(TestConstants.ACTUAL_PERCENTAGE);
        request.setActualCost(TestConstants.ACTUAL_COST);

        return request;

    }

    /*
     * =========================
     * RESPONSE
     * =========================
     */

    public static ActivityResponse response() {

        return response(entity());

    }

    public static ActivityResponse response(Activity activity) {

        ActivityResponse response = new ActivityResponse();

        response.setId(activity.getId());
        response.setProjectId(activity.getProject().getId());
        response.setName(activity.getName());
        response.setBudgetAtCompletion(activity.getBudgetAtCompletion());
        response.setPlannedPercentage(activity.getPlannedPercentage());
        response.setActualPercentage(activity.getActualPercentage());
        response.setActualCost(activity.getActualCost());

        return response;

    }

}