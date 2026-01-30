package com.marnaud.gaming_coach_booking.exception;

import java.time.LocalDateTime;

public record ErrorResponse(int statusCode, String error, String message, String path, LocalDateTime timestamp) {

    public ErrorResponse(int status, String error, String message, String path) {
        this(status, error, message, path, LocalDateTime.now());
    }
}
