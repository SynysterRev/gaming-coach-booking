package com.marnaud.gaming_coach_booking.mapper;

import com.marnaud.gaming_coach_booking.dto.UserDTO;
import com.marnaud.gaming_coach_booking.entity.AppUser;
import com.marnaud.gaming_coach_booking.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CoachMapper.class, GamerMapper.class})
public interface UserMapper {

    @Mapping(target = "roles", expression = "java(mapRoles(user.getRoles()))")
    UserDTO toDTO(AppUser user);
//    AppUser toEntity(UserDTO userDTO);

    default List<String> mapRoles(List<Role> roles) {
        return roles == null ? null : roles.stream().map(Role::getName).toList();
    }
}
