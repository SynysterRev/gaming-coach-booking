package com.marnaud.gaming_coach_booking.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends BaseApiException {
    public InvalidCredentialsException(String message) {

        super(message, HttpStatus.UNAUTHORIZED);
    }
}
