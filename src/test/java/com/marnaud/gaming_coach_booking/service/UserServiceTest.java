package com.marnaud.gaming_coach_booking.service;

import com.marnaud.gaming_coach_booking.dto.CoachDTO;
import com.marnaud.gaming_coach_booking.dto.GamerDTO;
import com.marnaud.gaming_coach_booking.dto.UserDTO;
import com.marnaud.gaming_coach_booking.entity.AppUser;
import com.marnaud.gaming_coach_booking.entity.Coach;
import com.marnaud.gaming_coach_booking.entity.Gamer;
import com.marnaud.gaming_coach_booking.entity.Role;
import com.marnaud.gaming_coach_booking.exception.UserNotFoundException;
import com.marnaud.gaming_coach_booking.mapper.UserMapper;
import com.marnaud.gaming_coach_booking.repository.AppUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private AppUserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    private List<Role> createCoachRole() {
        return List.of(Role.builder()
                .id(1)
                .name("ROLE_COACH")
                .build());
    }

    private AppUser createTestUser() {
        return AppUser.builder()
                .id(1)
                .email("test@test.fr")
                .username("test")
                .roles(createCoachRole())
                .build();
    }

    @Test
    void shouldReturnUserInfo() {
        //given
        List<Role> roles = createCoachRole();
        AppUser user = createTestUser();
        UserDTO expectedUser = new UserDTO("test@test.fr", "test",
                roles.stream().map(Role::getName).toList()
                , null, null);
        when(userRepository.findAllInfoById(1)).thenReturn(Optional.of(user));
        when(userMapper.toDTO(user)).thenReturn(expectedUser);

        //when
        UserDTO result = userService.getUserInfos(1);

        //then
        assertEquals(expectedUser, result);
        verify(userRepository).findAllInfoById(1);
        verify(userMapper).toDTO(user);
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        //given
        when(userRepository.findAllInfoById(999)).thenReturn(Optional.empty());

        //when
        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> userService.getUserInfos(999));

        //then
        assertEquals("Can't find user with id 999", exception.getMessage());
    }

    @Test
    void shouldReturnUserInfoWithCoach() {
        //given
        List<Role> roles = createCoachRole();
        AppUser user = createTestUser();

        Coach coach = Coach.builder()
                .bio("This is a bio")
                .hourlyRate(new BigDecimal("15.0"))
                .build();
        user.setCoach(coach);
        CoachDTO expectedCoach = new CoachDTO("This is a bio", new BigDecimal("15.0"));
        UserDTO expectedUser = new UserDTO("test@test.fr", "test",
                roles.stream().map(Role::getName).toList()
                , expectedCoach, null);
        when(userRepository.findAllInfoById(1)).thenReturn(Optional.of(user));
        when(userMapper.toDTO(user)).thenReturn(expectedUser);

        //when
        UserDTO result = userService.getUserInfos(1);

        //then
        assertEquals(expectedUser, result);
        verify(userRepository).findAllInfoById(1);
        verify(userMapper).toDTO(user);
    }

    @Test
    void shouldReturnUserInfoWithGamer() {
        //given
        List<Role> roles = createCoachRole();
        AppUser user = createTestUser();
        Gamer gamer = Gamer.builder()
                .build();
        user.setGamer(gamer);
        GamerDTO expectedGamer = new GamerDTO();
        UserDTO expectedUser = new UserDTO("test@test.fr", "test",
                roles.stream().map(Role::getName).toList()
                , null, expectedGamer);
        when(userRepository.findAllInfoById(1)).thenReturn(Optional.of(user));
        when(userMapper.toDTO(user)).thenReturn(expectedUser);

        //when
        UserDTO result = userService.getUserInfos(1);

        //then
        assertEquals(expectedUser, result);
        verify(userRepository).findAllInfoById(1);
        verify(userMapper).toDTO(user);
    }
}
