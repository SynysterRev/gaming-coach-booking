package com.marnaud.gaming_coach_booking.service;

import com.marnaud.gaming_coach_booking.dto.AuthResponseDTO;
import com.marnaud.gaming_coach_booking.dto.LoginDTO;
import com.marnaud.gaming_coach_booking.dto.RegisterDTO;
import com.marnaud.gaming_coach_booking.entity.AppUser;
import com.marnaud.gaming_coach_booking.entity.Coach;
import com.marnaud.gaming_coach_booking.entity.Role;
import com.marnaud.gaming_coach_booking.exception.InvalidCredentialsException;
import com.marnaud.gaming_coach_booking.exception.RoleNotFoundException;
import com.marnaud.gaming_coach_booking.exception.UserAlreadyExistsException;
import com.marnaud.gaming_coach_booking.repository.AppUserRepository;
import com.marnaud.gaming_coach_booking.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private AppUserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private RoleRepository roleRepository;

    @Test
    void shouldRegisterUser() {
        Role coachRole = Role.builder()
                .id(1)
                .name("ROLE_COACH")
                .build();
        RegisterDTO registerDTO = new RegisterDTO(
                "test@test.fr",
                "test123",
                "test",
                "ROLE_COACH"
        );
        Coach coach = Coach.builder()
                .id(1)
                .bio("a bio")
                .hourlyRate(new BigDecimal("15"))
                .build();
        AppUser user = AppUser.builder()
                .id(1)
                .email("test@test.fr")
                .username("test")
                .roles(List.of(Role.builder()
                        .id(1)
                        .name("ROLE_COACH")
                        .build()))
                .coach(coach)
                .build();
        AuthResponseDTO expectedResponse = new AuthResponseDTO("secrettoken",
                "test@test.fr",
                "test",
                List.of("ROLE_COACH"));
        when(userRepository.existsByEmail("test@test.fr")).thenReturn(false);
        when(userRepository.existsByUsername("test")).thenReturn(false);
        when(roleRepository.findByName("ROLE_COACH")).thenReturn(Optional.of(coachRole));
        when(passwordEncoder.encode("test123")).thenReturn("h4ach3dpwd");
        when(userRepository.save(any(AppUser.class))).thenReturn(user);
        when(jwtService.generateToken(any(CustomUserDetails.class))).thenReturn("secrettoken");

        //when
        AuthResponseDTO responseDTO = authService.register(registerDTO);

        //then
        assertEquals(expectedResponse, responseDTO);
        verify(userRepository).existsByEmail("test@test.fr");
        verify(userRepository).existsByUsername("test");
        verify(passwordEncoder).encode("test123");
        verify(userRepository).save(any(AppUser.class));
        verify(jwtService).generateToken(any(CustomUserDetails.class));
    }

    @Test
    void shouldThrowExceptionWhenEmailAlreadyExists() {
        RegisterDTO registerDTO = new RegisterDTO(
                "test@test.fr",
                "test123",
                "test",
                "ROLE_COACH"
        );
        when(userRepository.existsByEmail("test@test.fr")).thenReturn(true);

        //when
        UserAlreadyExistsException exception = assertThrows(UserAlreadyExistsException.class,
                () -> authService.register(registerDTO));

        //then
        assertEquals("This email is already used.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenUsernameAlreadyExists() {
        RegisterDTO registerDTO = new RegisterDTO(
                "test@test.fr",
                "test123",
                "test",
                "ROLE_COACH"
        );
        when(userRepository.existsByEmail("test@test.fr")).thenReturn(false);
        when(userRepository.existsByUsername("test")).thenReturn(true);

        //when
        UserAlreadyExistsException exception = assertThrows(UserAlreadyExistsException.class,
                () -> authService.register(registerDTO));

        //then
        assertEquals("This username is already used.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenRoleNotFound() {
        RegisterDTO registerDTO = new RegisterDTO(
                "test@test.fr",
                "test123",
                "test",
                "ROLE_INVALID"
        );
        when(userRepository.existsByEmail("test@test.fr")).thenReturn(false);
        when(userRepository.existsByUsername("test")).thenReturn(false);
        when(roleRepository.findByName("ROLE_INVALID")).thenReturn(Optional.empty());

        //when
        RoleNotFoundException exception = assertThrows(RoleNotFoundException.class,
                () -> authService.register(registerDTO));

        //then
        assertEquals("Error : role ROLE_INVALID not found", exception.getMessage());
    }

    @Test
    void shouldLoginSuccessfully() {
        //given
        LoginDTO loginDTO = new LoginDTO("test@test.fr", "password123");

        AuthResponseDTO expectedResponse = new AuthResponseDTO(
                "token123",
                "test@test.fr",
                "test",
                List.of("ROLE_COACH")
        );

        AppUser user = AppUser.builder()
                .email("test@test.fr")
                .username("test")
                .roles(List.of(Role.builder().name("ROLE_COACH").build()))
                .build();

        CustomUserDetails userDetails = new CustomUserDetails(user);

        // Mock Authentication
        Authentication authResponse = mock(Authentication.class);
        when(authResponse.getPrincipal()).thenReturn(userDetails);

        when(authenticationManager.authenticate(any(Authentication.class)))
                .thenReturn(authResponse);
        when(jwtService.generateToken(userDetails)).thenReturn("token123");

        //when
        AuthResponseDTO result = authService.login(loginDTO);

        //then
        assertEquals(expectedResponse, result);
    }

    @Test
    void shouldThrowExceptionWhenInvalidCredentials() {
        //given
        LoginDTO loginDTO = new LoginDTO("test@test.fr", "wrongpassword");

        when(authenticationManager.authenticate(any(Authentication.class)))
                .thenThrow(new BadCredentialsException("Bad credentials"));

        //when
        InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class,
                () -> authService.login(loginDTO));

        //then
        assertEquals("Email or password incorrect.", exception.getMessage());
    }
}
