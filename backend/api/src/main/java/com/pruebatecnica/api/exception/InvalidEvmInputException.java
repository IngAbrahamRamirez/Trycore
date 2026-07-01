package com.pruebatecnica.api.exception;

public class InvalidEvmInputException extends RuntimeException {

    public InvalidEvmInputException(String message) {
        super(message);
    }
}