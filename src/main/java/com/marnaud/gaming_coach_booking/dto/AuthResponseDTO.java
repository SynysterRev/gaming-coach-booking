package com.marnaud.gaming_coach_booking.dto;

public record AuthResponseDTO(String token,
                              String email,
                              String username,
                              String role) {
}
