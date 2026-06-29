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

import com.pruebatecnica.api.dto.user.UserRequest;
import com.pruebatecnica.api.dto.user.UserResponse;
import com.pruebatecnica.api.fixtures.UserFactory;
import com.pruebatecnica.api.service.user.UserService;
import com.pruebatecnica.api.support.JsonUtils;
import com.pruebatecnica.api.support.MockMvcHelper;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    @DisplayName("Should create user")
    void shouldCreateUser() throws Exception {

        // Arrange

        UserRequest request = UserFactory.request();

        UserResponse response = UserFactory.response();

        when(service.create(any(UserRequest.class)))
                .thenReturn(response);

        // Act & Assert

        mockMvc.perform(post("/api/users")
                        .contentType(MockMvcHelper.JSON)
                        .content(JsonUtils.toJson(request)))

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id")
                        .value(response.getId().toString()))
                .andExpect(jsonPath("$.firstName")
                        .value(response.getFirstName()))
                .andExpect(jsonPath("$.lastName")
                        .value(response.getLastName()))
                .andExpect(jsonPath("$.email")
                        .value(response.getEmail()))
                .andExpect(jsonPath("$.enabled")
                        .value(response.getEnabled()));

    }

    @Test
    @DisplayName("Should find all users")
    void shouldFindAllUsers() throws Exception {

        // Arrange

        UserResponse response = UserFactory.response();

        when(service.findAll())
                .thenReturn(List.of(response));

        // Act & Assert

        mockMvc.perform(get("/api/users"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id")
                        .value(response.getId().toString()))
                .andExpect(jsonPath("$[0].email")
                        .value(response.getEmail()));

    }

    @Test
    @DisplayName("Should find user by id")
    void shouldFindUserById() throws Exception {

        // Arrange

        UserResponse response = UserFactory.response();

        when(service.findById(response.getId()))
                .thenReturn(response);

        // Act & Assert

        mockMvc.perform(get("/api/users/{id}", response.getId()))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id")
                        .value(response.getId().toString()))
                .andExpect(jsonPath("$.email")
                        .value(response.getEmail()));

    }

    @Test
    @DisplayName("Should update user")
    void shouldUpdateUser() throws Exception {

        // Arrange

        UserRequest request = UserFactory.request();

        UserResponse response = UserFactory.response();

        when(service.update(any(), any(UserRequest.class)))
                .thenReturn(response);

        // Act & Assert

        mockMvc.perform(put("/api/users/{id}", response.getId())
                        .contentType(MockMvcHelper.JSON)
                        .content(JsonUtils.toJson(request)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id")
                        .value(response.getId().toString()))
                .andExpect(jsonPath("$.email")
                        .value(response.getEmail()));

    }

    @Test
    @DisplayName("Should delete user")
    void shouldDeleteUser() throws Exception {

        // Arrange

        UserResponse response = UserFactory.response();

        doNothing().when(service)
                .delete(response.getId());

        // Act & Assert

        mockMvc.perform(delete("/api/users/{id}", response.getId()))

                .andExpect(status().isNoContent());

    }

}