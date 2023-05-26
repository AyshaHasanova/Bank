package com.example.lesson4_5.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RestException {
    public NotFoundException(String errorCode, String errorDescription) {
        super(HttpStatus.NOT_FOUND, errorCode, errorDescription);
    }

    public static NotFoundException of(String errorCode, String description, Object... args) {
        return new NotFoundException(errorCode, String.format(description, args));
    }
}
