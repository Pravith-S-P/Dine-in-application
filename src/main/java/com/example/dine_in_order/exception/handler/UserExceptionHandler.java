package com.example.dine_in_order.exception.handler;

import com.example.dine_in_order.exception.UserNotFoundException;
import com.example.dine_in_order.util.ResponseBuilder;
import com.example.dine_in_order.util.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<SimpleErrorResponse> getMessage(UserNotFoundException exception) {
        return ResponseBuilder.error(HttpStatus.NOT_FOUND, exception.getMessage());
    }
}

