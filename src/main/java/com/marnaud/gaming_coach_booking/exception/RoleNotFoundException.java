package com.marnaud.gaming_coach_booking.exception;

import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends BaseApiException {
    public RoleNotFoundException(String message) {

        super(message, HttpStatus.NOT_FOUND);
    }
}
