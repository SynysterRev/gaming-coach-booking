package com.marnaud.gaming_coach_booking.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseApiException {
    public UserNotFoundException(String message) {

        super(message, HttpStatus.NOT_FOUND);
    }
}
