package com.pruebatecnica.api.fixtures;

import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.dto.user.UserRequest;
import com.pruebatecnica.api.dto.user.UserResponse;

public final class UserFactory {

    private UserFactory() {
    }

    /**
     * Entidad completamente inicializada.
     */
    public static User entity() {

        User user = User.builder()
                .firstName(TestConstants.FIRST_NAME)
                .lastName(TestConstants.LAST_NAME)
                .email(TestConstants.EMAIL)
                .password(TestConstants.PASSWORD)
                .enabled(true)
                .build();

        user.setId(TestConstants.USER_ID);

        return user;

    }

    /**
     * DTO utilizado para create/update.
     */
    public static UserRequest request() {

        UserRequest request = new UserRequest();

        request.setFirstName(TestConstants.FIRST_NAME);
        request.setLastName(TestConstants.LAST_NAME);
        request.setEmail(TestConstants.EMAIL);
        request.setPassword(TestConstants.PASSWORD);

        return request;

    }

    /**
     * DTO esperado por el controlador.
     */
    public static UserResponse response() {

        UserResponse response = new UserResponse();

        response.setId(TestConstants.USER_ID);
        response.setFirstName(TestConstants.FIRST_NAME);
        response.setLastName(TestConstants.LAST_NAME);
        response.setEmail(TestConstants.EMAIL);
        response.setEnabled(true);

        return response;

    }

}