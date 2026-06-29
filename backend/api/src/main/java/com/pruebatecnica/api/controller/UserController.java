package com.pruebatecnica.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.pruebatecnica.api.dto.user.UserRequest;
import com.pruebatecnica.api.dto.user.UserResponse;
import com.pruebatecnica.api.service.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(
            @Valid @RequestBody UserRequest request) {

        return userService.create(request);
    }

    @GetMapping
    public List<UserResponse> findAll() {

        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse findById(
            @PathVariable UUID id) {

        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public UserResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody UserRequest request) {

        return userService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID id) {

        userService.delete(id);
    }

}