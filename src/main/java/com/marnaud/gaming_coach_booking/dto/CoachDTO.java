package com.marnaud.gaming_coach_booking.dto;

import java.math.BigDecimal;

public record CoachDTO(
        String bio,
        BigDecimal hourlyRate
) {
}
