package com.marnaud.gaming_coach_booking.service;

import com.marnaud.gaming_coach_booking.dto.AuthResponseDTO;
import com.marnaud.gaming_coach_booking.dto.RegisterDTO;
import com.marnaud.gaming_coach_booking.entity.*;
import com.marnaud.gaming_coach_booking.exception.UserAlreadyExistsException;
import com.marnaud.gaming_coach_booking.repository.AppUserRepository;
import com.marnaud.gaming_coach_booking.repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class AuthService {
    private final AppUserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AppUserRepository userRepository,
                       JwtService jwtService,
                       PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
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
                registerDTO.role()
        );
    }
}
