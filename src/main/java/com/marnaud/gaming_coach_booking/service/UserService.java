package com.marnaud.gaming_coach_booking.service;

import com.marnaud.gaming_coach_booking.dto.CoachDTO;
import com.marnaud.gaming_coach_booking.dto.UserDTO;
import com.marnaud.gaming_coach_booking.entity.AppUser;
import com.marnaud.gaming_coach_booking.exception.UserNotFoundException;
import com.marnaud.gaming_coach_booking.mapper.UserMapper;
import com.marnaud.gaming_coach_booking.repository.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final AppUserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(AppUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO getUserInfos(long id) {
        AppUser user = userRepository.findAllInfoById(id).orElseThrow(() -> new UserNotFoundException("Can't find user with id " + id));

        return userMapper.toDTO(user);
    }
}
