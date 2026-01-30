package com.marnaud.gaming_coach_booking.exception;

import org.springframework.http.HttpStatus;

public class BaseApiException extends RuntimeException {

    private final HttpStatus status;
    public BaseApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
