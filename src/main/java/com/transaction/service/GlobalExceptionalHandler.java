package com.transaction.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> processServiceException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
