package com.example.lesson4_5.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiError {
    private String errorCode;
    private String message;
}
