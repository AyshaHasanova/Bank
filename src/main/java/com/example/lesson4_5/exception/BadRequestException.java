package com.example.lesson4_5.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RestException {
    public BadRequestException(String errorCode, String errorDescription) {
        super(HttpStatus.BAD_REQUEST, errorCode, errorDescription);
    }
}
