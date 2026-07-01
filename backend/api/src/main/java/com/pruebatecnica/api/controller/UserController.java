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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Operations related to user management")

public class UserController {

    private final UserService userService;

    @PostMapping
    @Operation(summary = "Create user", description = "Creates a new user in the system.")

    @ApiResponses({

            @ApiResponse(responseCode = "201", description = "User created successfully"),

            @ApiResponse(responseCode = "400", description = "Invalid request")

    })
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(
            @Valid @RequestBody

            @io.swagger.v3.oas.annotations.parameters.RequestBody(

                    description = "User information",

                    required = true

            ) UserRequest request) {

        return userService.create(request);
    }

    @Operation(summary = "Find all users", description = "Retrieves a list of all users.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
    })
    @GetMapping
    public List<UserResponse> findAll() {

        return userService.findAll();
    }

    @Operation(summary = "Find user by ID", description = "Retrieves a user by their unique identifier.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public UserResponse findById(
            @Parameter(description = "User identifier", example = "4efaf7d0-87c2-4a6f-a6d4-6b1f7e2d4b8a") @PathVariable UUID id) {

        return userService.findById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user", description = "Updates an existing user.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })

    public UserResponse update(
            @Parameter(description = "User identifier", example = "4efaf7d0-87c2-4a6f-a6d4-6b1f7e2d4b8a") @PathVariable UUID id,
            @Valid @RequestBody

            @io.swagger.v3.oas.annotations.parameters.RequestBody(

                    description = "User information to update",

                    required = true

            ) UserRequest request) {

        return userService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user", description = "Deletes a user by their unique identifier.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @Parameter(description = "User identifier", example = "4efaf7d0-87c2-4a6f-a6d4-6b1f7e2d4b8a") @PathVariable UUID id) {

        userService.delete(id);
    }

}