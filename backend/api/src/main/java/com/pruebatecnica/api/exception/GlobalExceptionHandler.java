package com.pruebatecnica.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pruebatecnica.api.dto.common.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(BusinessException.class)
        public ResponseEntity<ErrorResponse> handleBusinessException(
                        BusinessException exception) {

                ErrorResponse response = ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST.value())
                                .error(exception.getMessage())
                                .build();

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(response);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleException(
                        Exception exception) {

                ErrorResponse response = ErrorResponse.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .error(exception.getMessage())
                                .build();

                return ResponseEntity
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(response);
        }
}