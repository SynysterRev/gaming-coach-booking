package com.marnaud.gaming_coach_booking.controller;

import com.marnaud.gaming_coach_booking.dto.AuthResponseDTO;
import com.marnaud.gaming_coach_booking.dto.LoginDTO;
import com.marnaud.gaming_coach_booking.dto.RegisterDTO;
import com.marnaud.gaming_coach_booking.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {

        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponseDTO register(@Valid @RequestBody RegisterDTO registerDTO) {
        return authService.register(registerDTO);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@Valid @RequestBody LoginDTO loginDTO) {
        return authService.login(loginDTO);
    }
}
