package com.marnaud.gaming_coach_booking.mapper;

import com.marnaud.gaming_coach_booking.dto.CoachDTO;
import com.marnaud.gaming_coach_booking.dto.GamerDTO;
import com.marnaud.gaming_coach_booking.dto.UserDTO;
import com.marnaud.gaming_coach_booking.entity.AppUser;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-02T17:56:34+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private CoachMapper coachMapper;
    @Autowired
    private GamerMapper gamerMapper;

    @Override
    public UserDTO toDTO(AppUser user) {
        if ( user == null ) {
            return null;
        }

        String email = null;
        String username = null;
        CoachDTO coach = null;
        GamerDTO gamer = null;

        email = user.getEmail();
        username = user.getUsername();
        coach = coachMapper.toDTO( user.getCoach() );
        gamer = gamerMapper.toDTO( user.getGamer() );

        List<String> roles = mapRoles(user.getRoles());

        UserDTO userDTO = new UserDTO( email, username, roles, coach, gamer );

        return userDTO;
    }
}
