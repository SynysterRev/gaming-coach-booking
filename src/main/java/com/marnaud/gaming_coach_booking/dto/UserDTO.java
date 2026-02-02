package com.marnaud.gaming_coach_booking.dto;

import java.util.List;

public record UserDTO(
        String email,
        String username,
        List<String> roles,
        CoachDTO coach,
        GamerDTO gamer
) {
}
