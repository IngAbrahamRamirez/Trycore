package com.pruebatecnica.api.service.user;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.exception.BusinessException;
import com.pruebatecnica.api.exception.ResourceNotFoundException;
import com.pruebatecnica.api.fixtures.UserFactory;
import com.pruebatecnica.api.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserValidatorTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserValidator validator;

    private UUID userId;

    private User user;

    @BeforeEach
    void setUp() {

        user = UserFactory.entity();

        userId = user.getId();

    }

    @Test
    @DisplayName("Should validate create when email does not exist")
    void shouldValidateCreate() {

        when(userRepository.existsByEmail(user.getEmail()))
                .thenReturn(false);

        assertDoesNotThrow(() -> validator.validateCreate(user.getEmail()));

        verify(userRepository).existsByEmail(user.getEmail());

    }

    @Test
    @DisplayName("Should throw exception when email already exists")
    void shouldRejectDuplicateEmail() {

        when(userRepository.existsByEmail(user.getEmail()))
                .thenReturn(true);

        assertThrows(
                BusinessException.class,
                () -> validator.validateCreate(user.getEmail()));

    }

    @Test
    @DisplayName("Should return user when exists")
    void shouldReturnExistingUser() {

        when(userRepository.findById(userId))
                .thenReturn(Optional.of(user));

        User result = validator.validateExists(userId);

        assertEquals(user, result);

    }

    @Test
    @DisplayName("Should throw exception when user does not exist")
    void shouldThrowWhenUserNotExists() {

        when(userRepository.findById(userId))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> validator.validateExists(userId));

    }

    @Test
    @DisplayName("Should validate update when email belongs to same user")
    void shouldValidateUpdate() {

        when(userRepository.existsByEmailAndIdNot(
                user.getEmail(),
                userId))
                .thenReturn(false);

        assertDoesNotThrow(() -> validator.validateUpdate(
                userId,
                user.getEmail()));

    }

    @Test
    @DisplayName("Should reject update when another user has same email")
    void shouldRejectDuplicateEmailOnUpdate() {

        when(userRepository.existsByEmailAndIdNot(
                user.getEmail(),
                userId))
                .thenReturn(true);

        assertThrows(
                BusinessException.class,
                () -> validator.validateUpdate(
                        userId,
                        user.getEmail()));

    }

}