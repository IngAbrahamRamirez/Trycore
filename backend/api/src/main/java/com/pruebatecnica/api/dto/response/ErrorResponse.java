package com.pruebatecnica.api.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private LocalDateTime timestamp;

    private Integer status;

    private String error;

}