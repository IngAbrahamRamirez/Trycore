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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pruebatecnica.api.dto.project.ProjectRequest;
import com.pruebatecnica.api.dto.project.ProjectResponse;
import com.pruebatecnica.api.fixtures.ProjectFactory;
import com.pruebatecnica.api.service.project.ProjectService;
import com.pruebatecnica.api.support.EndpointConstants;
import com.pruebatecnica.api.support.JsonUtils;
import com.pruebatecnica.api.support.MockMvcHelper;

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService service;

    @Test
    @DisplayName("Should create project")
    void shouldCreateProject() throws Exception {

        // Arrange

        ProjectRequest request = ProjectFactory.request();

        ProjectResponse response = ProjectFactory.response();

        when(service.create(any(ProjectRequest.class)))
                .thenReturn(response);

        // Act & Assert

        mockMvc.perform(post(EndpointConstants.PROJECTS)
                        .contentType(MockMvcHelper.JSON)
                        .content(JsonUtils.toJson(request)))

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id")
                        .value(response.getId().toString()))
                .andExpect(jsonPath("$.name")
                        .value(response.getName()))
                .andExpect(jsonPath("$.description")
                        .value(response.getDescription()))
                .andExpect(jsonPath("$.status")
                        .value(response.getStatus().name()));

    }

    @Test
    @DisplayName("Should find all projects")
    void shouldFindAllProjects() throws Exception {

        // Arrange

        ProjectResponse response = ProjectFactory.response();

        when(service.findAll())
                .thenReturn(List.of(response));

        // Act & Assert

        mockMvc.perform(get(EndpointConstants.PROJECTS))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id")
                        .value(response.getId().toString()));

    }

    @Test
    @DisplayName("Should find project by id")
    void shouldFindProjectById() throws Exception {

        // Arrange

        ProjectResponse response = ProjectFactory.response();

        when(service.findById(response.getId()))
                .thenReturn(response);

        // Act & Assert

        mockMvc.perform(get(
                EndpointConstants.PROJECTS + "/{id}",
                response.getId()))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id")
                        .value(response.getId().toString()))
                .andExpect(jsonPath("$.name")
                        .value(response.getName()));

    }

    @Test
    @DisplayName("Should update project")
    void shouldUpdateProject() throws Exception {

        // Arrange

        ProjectRequest request = ProjectFactory.request();

        ProjectResponse response = ProjectFactory.response();

        when(service.update(any(), any(ProjectRequest.class)))
                .thenReturn(response);

        // Act & Assert

        mockMvc.perform(put(
                        EndpointConstants.PROJECTS + "/{id}",
                        response.getId())
                        .contentType(MockMvcHelper.JSON)
                        .content(JsonUtils.toJson(request)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id")
                        .value(response.getId().toString()))
                .andExpect(jsonPath("$.name")
                        .value(response.getName()));

    }

    @Test
    @DisplayName("Should delete project")
    void shouldDeleteProject() throws Exception {

        // Arrange

        ProjectResponse response = ProjectFactory.response();

        doNothing().when(service)
                .delete(response.getId());

        // Act & Assert

        mockMvc.perform(delete(
                EndpointConstants.PROJECTS + "/{id}",
                response.getId()))

                .andExpect(status().isNoContent());

    }

}