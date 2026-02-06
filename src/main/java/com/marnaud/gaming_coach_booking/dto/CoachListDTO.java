package com.marnaud.gaming_coach_booking.dto;

import java.math.BigDecimal;
import java.util.List;

public record CoachListDTO(
        Long id,
        String username,  // du user
        String bio,
        BigDecimal hourlyRate,
        List<String> games) {
}
