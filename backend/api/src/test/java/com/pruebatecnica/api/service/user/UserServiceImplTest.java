package com.pruebatecnica.api.service.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.dto.user.UserRequest;
import com.pruebatecnica.api.dto.user.UserResponse;
import com.pruebatecnica.api.fixtures.UserFactory;
import com.pruebatecnica.api.mapper.UserMapper;
import com.pruebatecnica.api.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper mapper;

    @Mock
    private UserValidator validator;

    @InjectMocks
    private UserServiceImpl service;

    private UUID id;

    private User user;

    private UserRequest request;

    private UserResponse response;

    @BeforeEach
    void setUp() {

        user = UserFactory.entity();

        id = user.getId();

        request = UserFactory.request();

        response = UserFactory.response();

    }

    @Test
    @DisplayName("Should create user")
    void shouldCreateUser() {

        doNothing().when(validator)
                .validateCreate(request.getEmail());

        when(mapper.toEntity(request))
                .thenReturn(user);

        when(repository.save(user))
                .thenReturn(user);

        when(mapper.toResponse(user))
                .thenReturn(response);

        UserResponse result = service.create(request);

        assertSame(response, result);

        verify(validator).validateCreate(request.getEmail());
        verify(repository).save(user);

    }

    @Test
    @DisplayName("Should find all users")
    void shouldFindAllUsers() {

        when(repository.findAll())
                .thenReturn(List.of(user));

        when(mapper.toResponseList(List.of(user)))
                .thenReturn(List.of(response));

        List<UserResponse> result = service.findAll();

        assertEquals(1, result.size());

        verify(repository).findAll();

    }

    @Test
    @DisplayName("Should find user by id")
    void shouldFindById() {

        when(validator.validateExists(id))
                .thenReturn(user);

        when(mapper.toResponse(user))
                .thenReturn(response);

        UserResponse result = service.findById(id);

        assertSame(response, result);

    }

    @Test
    @DisplayName("Should update user")
    void shouldUpdateUser() {

        when(validator.validateExists(id))
                .thenReturn(user);

        doNothing().when(validator)
                .validateUpdate(id, request.getEmail());

        doNothing().when(mapper)
                .updateEntity(request, user);

        when(repository.save(user))
                .thenReturn(user);

        when(mapper.toResponse(user))
                .thenReturn(response);

        UserResponse result = service.update(id, request);

        assertSame(response, result);

        verify(mapper).updateEntity(request, user);

    }

    @Test
    @DisplayName("Should delete user")
    void shouldDeleteUser() {

        when(validator.validateExists(id))
                .thenReturn(user);

        service.delete(id);

        verify(repository).delete(user);

    }

}