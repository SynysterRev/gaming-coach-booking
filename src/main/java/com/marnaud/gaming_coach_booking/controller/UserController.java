package com.marnaud.gaming_coach_booking.controller;

import com.marnaud.gaming_coach_booking.dto.UserDTO;
import com.marnaud.gaming_coach_booking.service.CustomUserDetails;
import com.marnaud.gaming_coach_booking.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/me")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public UserDTO getUserInfo(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return userService.getUserInfos(userDetails.user().getId());
    }
}
