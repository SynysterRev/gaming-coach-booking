package com.marnaud.gaming_coach_booking.dto;

import java.util.List;

public record AuthResponseDTO(String token,
                              String email,
                              String username,
                              List<String> roles) {
}
