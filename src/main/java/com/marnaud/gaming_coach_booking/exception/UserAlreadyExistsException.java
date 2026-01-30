package com.marnaud.gaming_coach_booking.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends BaseApiException {
    public UserAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
