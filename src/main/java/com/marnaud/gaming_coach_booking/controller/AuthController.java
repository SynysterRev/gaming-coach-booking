package com.marnaud.gaming_coach_booking.controller;

import com.marnaud.gaming_coach_booking.dto.AuthResponseDTO;
import com.marnaud.gaming_coach_booking.dto.RegisterDTO;
import com.marnaud.gaming_coach_booking.entity.AppUser;
import com.marnaud.gaming_coach_booking.service.AuthService;
import com.marnaud.gaming_coach_booking.service.JwtService;
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
    private final JwtService jwtService;

    @Autowired
    public AuthController(AuthService authService, JwtService jwtService) {

        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public AuthResponseDTO register(@Valid @RequestBody RegisterDTO registerDTO) {
        return authService.register(registerDTO);
    }

//    @PostMapping("/login")
//    public String login()
}
