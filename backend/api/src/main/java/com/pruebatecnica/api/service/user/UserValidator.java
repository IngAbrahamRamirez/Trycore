package com.pruebatecnica.api.service.user;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.exception.BusinessException;
import com.pruebatecnica.api.exception.ResourceNotFoundException;
import com.pruebatecnica.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public void validateCreate(String email) {

        if (userRepository.existsByEmail(email)) {
            throw new BusinessException(
                    "A user with this email already exists.");
        }
    }

    public User validateExists(UUID id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found."));
    }

    public void validateUpdate(UUID id, String email) {

        if (userRepository.existsByEmailAndIdNot(email, id)) {
            throw new BusinessException(
                    "Another user is already registered with this email.");
        }
    }

}