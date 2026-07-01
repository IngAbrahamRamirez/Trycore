package com.pruebatecnica.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pruebatecnica.api.dto.activity.ActivityRequest;
import com.pruebatecnica.api.dto.activity.ActivityResponse;
import com.pruebatecnica.api.dto.common.MetricsResponse;
import com.pruebatecnica.api.fixtures.ActivityFactory;
import com.pruebatecnica.api.fixtures.MetricsFactory;
import com.pruebatecnica.api.service.activity.ActivityMetricsService;
import com.pruebatecnica.api.service.activity.ActivityService;
import com.pruebatecnica.api.support.EndpointConstants;
import com.pruebatecnica.api.support.JsonUtils;
import com.pruebatecnica.api.support.MockMvcHelper;

@WebMvcTest(ActivityController.class)
class ActivityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActivityService service;

    @MockBean
    private ActivityMetricsService metricsService;

    @Test
    @DisplayName("Should create activity")
    void shouldCreateActivity() throws Exception {

        ActivityRequest request = ActivityFactory.request();

        ActivityResponse response = ActivityFactory.response();

        when(service.create(any(ActivityRequest.class)))
                .thenReturn(response);

        mockMvc.perform(post(EndpointConstants.ACTIVITIES)
                        .contentType(MockMvcHelper.JSON)
                        .content(JsonUtils.toJson(request)))

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(response.getId().toString()))
                .andExpect(jsonPath("$.name").value(response.getName()));

    }

    @Test
    @DisplayName("Should find all activities")
    void shouldFindAllActivities() throws Exception {

        ActivityResponse response = ActivityFactory.response();

        when(service.findAll())
                .thenReturn(List.of(response));

        mockMvc.perform(get(EndpointConstants.ACTIVITIES))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));

    }

    @Test
    @DisplayName("Should find activity by id")
    void shouldFindActivityById() throws Exception {

        ActivityResponse response = ActivityFactory.response();

        when(service.findById(response.getId()))
                .thenReturn(response);

        mockMvc.perform(get(
                EndpointConstants.ACTIVITIES + "/{id}",
                response.getId()))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id")
                        .value(response.getId().toString()));

    }

    @Test
    @DisplayName("Should find activities by project")
    void shouldFindActivitiesByProject() throws Exception {

        UUID projectId = UUID.randomUUID();

        ActivityResponse response = ActivityFactory.response();

        when(service.findByProject(projectId))
                .thenReturn(List.of(response));

        mockMvc.perform(get(
                EndpointConstants.ACTIVITIES + "/project/{projectId}",
                projectId))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));

    }

    @Test
    @DisplayName("Should update activity")
    void shouldUpdateActivity() throws Exception {

        ActivityRequest request = ActivityFactory.request();

        ActivityResponse response = ActivityFactory.response();

        when(service.update(any(), any(ActivityRequest.class)))
                .thenReturn(response);

        mockMvc.perform(put(
                        EndpointConstants.ACTIVITIES + "/{id}",
                        response.getId())
                        .contentType(MockMvcHelper.JSON)
                        .content(JsonUtils.toJson(request)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id")
                        .value(response.getId().toString()));

    }

    @Test
    @DisplayName("Should delete activity")
    void shouldDeleteActivity() throws Exception {

        ActivityResponse response = ActivityFactory.response();

        doNothing().when(service)
                .delete(response.getId());

        mockMvc.perform(delete(
                EndpointConstants.ACTIVITIES + "/{id}",
                response.getId()))

                .andExpect(status().isNoContent());

    }

    @Test
    @DisplayName("Should return activity metrics")
    void shouldReturnMetrics() throws Exception {

        ActivityResponse response = ActivityFactory.response();

        MetricsResponse metrics = MetricsFactory.response();

        when(metricsService.calculate(response.getId()))
                .thenReturn(metrics);

        mockMvc.perform(get(
                EndpointConstants.ACTIVITIES + "/{id}/metrics",
                response.getId()))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pv").value(metrics.getPv().doubleValue()))
                .andExpect(jsonPath("$.ev").value(metrics.getEv().doubleValue()))
                .andExpect(jsonPath("$.cv").value(metrics.getCv().doubleValue()))
                .andExpect(jsonPath("$.sv").value(metrics.getSv().doubleValue()));

    }

}