package com.example.dine_in_order.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {
    public static <T>ResponseEntity<ResponseStructure<T>> success(HttpStatus status,String message,T data)
    {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
            .message(message)
            .data(data)
            .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(structure);
    }

    public static <T>ResponseEntity<ResponseStructure<T>> success(HttpStatus status, HttpHeaders headers, String message, T data)
    {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(structure);
    }


    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status,String message)
    {
        SimpleErrorResponse error = new SimpleErrorResponse.SimpleErrorResponseBuilder()
                .type(status.name())
                .status(status.value())
                .message(message)
                .build();
        return ResponseEntity.status(status)
                .body(error);
    }
}
