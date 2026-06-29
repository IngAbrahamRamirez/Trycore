package com.pruebatecnica.api.service.user;

import java.util.List;
import java.util.UUID;

import com.pruebatecnica.api.dto.user.UserRequest;
import com.pruebatecnica.api.dto.user.UserResponse;

public interface UserService {

    UserResponse create(UserRequest request);

    List<UserResponse> findAll();

    UserResponse findById(UUID id);

    UserResponse update(UUID id, UserRequest request);

    void delete(UUID id);

}