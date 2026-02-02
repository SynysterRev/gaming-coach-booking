package com.marnaud.gaming_coach_booking.service;

import com.marnaud.gaming_coach_booking.dto.AuthResponseDTO;
import com.marnaud.gaming_coach_booking.dto.LoginDTO;
import com.marnaud.gaming_coach_booking.dto.RegisterDTO;
import com.marnaud.gaming_coach_booking.entity.*;
import com.marnaud.gaming_coach_booking.exception.InvalidCredentialsException;
import com.marnaud.gaming_coach_booking.exception.UserAlreadyExistsException;
import com.marnaud.gaming_coach_booking.repository.AppUserRepository;
import com.marnaud.gaming_coach_booking.repository.RoleRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class AuthService {
    private final AppUserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(AppUserRepository userRepository,
                       JwtService jwtService,
                       PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository,
                       AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
    }

    @Transactional
    public AuthResponseDTO register(RegisterDTO registerDTO) {
        if (userRepository.existsByEmail(registerDTO.email())) {
            throw new UserAlreadyExistsException("This email is already used.");
        }

        if(userRepository.existsByUsername(registerDTO.username())) {
            throw new UserAlreadyExistsException("This username is already used.");
        }

        AppUser user = AppUser.builder()
                .email(registerDTO.email())
                .password(passwordEncoder.encode(registerDTO.password()))
                .username(registerDTO.username())
                .build();

        // change to a custom exception
        Role role = roleRepository.findByName(registerDTO.role())
                .orElseThrow(() -> new RuntimeException(("Error : role " + registerDTO.role() + " not found")));

        user.addRole(role);

        if (RoleName.ROLE_COACH.toString().equals(registerDTO.role())) {
            Coach coach = new Coach();

            user.setCoach(coach);
        } else if (RoleName.ROLE_GAMER.toString().equals(registerDTO.role())) {
            Gamer gamer = new Gamer();

            user.setGamer(gamer);
        }

        AppUser savedUser = userRepository.save(user);

        CustomUserDetails userDetails = new CustomUserDetails(savedUser);
        String token = jwtService.generateToken(userDetails);
        return new AuthResponseDTO(
                token,
                savedUser.getEmail(),
                savedUser.getUsername(),
                Collections.singletonList(registerDTO.role())
        );
    }

    public AuthResponseDTO login(LoginDTO loginDTO) {
        Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(loginDTO.email(), loginDTO.password());
        try {
            Authentication authenticationResponse = authenticationManager.authenticate(authenticationRequest);

            CustomUserDetails userDetails = (CustomUserDetails) authenticationResponse.getPrincipal();

            AppUser user = userDetails.user();
            String token = jwtService.generateToken(userDetails);
            return new AuthResponseDTO(
                    token,
                    user.getEmail(),
                    user.getUsername(),
                    user.getRoles().stream().map(Role::getName).toList()
            );
        } catch (AuthenticationException e) {
            throw new InvalidCredentialsException("Email or password incorrect.");
        }
    }
}
