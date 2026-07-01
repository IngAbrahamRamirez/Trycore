package com.pruebatecnica.api.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.pruebatecnica.api.domain.entity.Activity;
import com.pruebatecnica.api.dto.activity.ActivityRequest;
import com.pruebatecnica.api.dto.activity.ActivityResponse;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
public interface ActivityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "project", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Activity toEntity(ActivityRequest request);

    @Mapping(target = "projectId", source = "project.id")
    ActivityResponse toResponse(Activity entity);

    List<ActivityResponse> toResponseList(List<Activity> entities);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "project", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(
            ActivityRequest request,
            @MappingTarget Activity entity
    );

}