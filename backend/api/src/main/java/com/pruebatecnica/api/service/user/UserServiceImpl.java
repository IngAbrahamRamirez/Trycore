package com.pruebatecnica.api.service.user;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.dto.user.UserRequest;
import com.pruebatecnica.api.dto.user.UserResponse;
import com.pruebatecnica.api.mapper.UserMapper;
import com.pruebatecnica.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;

    @Override
    public UserResponse create(UserRequest request) {

        userValidator.validateCreate(request.getEmail());

        User user = userMapper.toEntity(request);

        user.setEnabled(Boolean.TRUE);

        user = userRepository.save(user);

        return userMapper.toResponse(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {

        return userMapper.toResponseList(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse findById(UUID id) {

        User user = userValidator.validateExists(id);

        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse update(UUID id, UserRequest request) {

        User user = userValidator.validateExists(id);

        userValidator.validateUpdate(id, request.getEmail());

        userMapper.updateEntity(request, user);

        user = userRepository.save(user);

        return userMapper.toResponse(user);
    }

    @Override
    public void delete(UUID id) {

        User user = userValidator.validateExists(id);

        userRepository.delete(user);
    }

}