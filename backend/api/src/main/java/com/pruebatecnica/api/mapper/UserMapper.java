package com.pruebatecnica.api.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.pruebatecnica.api.domain.entity.User;
import com.pruebatecnica.api.dto.user.UserRequest;
import com.pruebatecnica.api.dto.user.UserResponse;

@Mapper(
    componentModel = "spring",
    builder = @Builder(disableBuilder = true)
)
public interface UserMapper {

    /**
     * Convierte un DTO de creación en una entidad.
     * Los campos administrados por el sistema se inicializan automáticamente.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "projects", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toEntity(UserRequest request);

    /**
     * Convierte una entidad en DTO de respuesta.
     */
    UserResponse toResponse(User entity);

    /**
     * Convierte una lista de entidades.
     */
    List<UserResponse> toResponseList(List<User> entities);

    /**
     * Actualiza únicamente los campos presentes en el DTO.
     * No modifica identificadores, auditoría ni relaciones.
     */
    @BeanMapping(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "projects", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(UserRequest request, @MappingTarget User entity);

}