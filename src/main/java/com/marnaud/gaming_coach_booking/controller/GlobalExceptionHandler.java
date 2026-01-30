package com.marnaud.gaming_coach_booking.controller;

import com.marnaud.gaming_coach_booking.exception.BaseApiException;
import com.marnaud.gaming_coach_booking.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseApiException.class)
    public ResponseEntity<ErrorResponse> handleBaseApiExceptions(BaseApiException exc, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(
                exc.getStatus().value(),
                exc.getStatus().getReasonPhrase(),
                exc.getMessage(),
                request.getRequestURI());
        return new ResponseEntity<ErrorResponse>(error, exc.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
