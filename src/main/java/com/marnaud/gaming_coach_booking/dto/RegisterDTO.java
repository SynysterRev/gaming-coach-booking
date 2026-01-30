package com.marnaud.gaming_coach_booking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank @Email String email,
        @NotBlank String password,
        @NotBlank String username,
        @NotBlank String role) {
}
