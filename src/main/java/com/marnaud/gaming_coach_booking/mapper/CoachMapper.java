package com.marnaud.gaming_coach_booking.mapper;

import com.marnaud.gaming_coach_booking.dto.CoachDTO;
import com.marnaud.gaming_coach_booking.dto.CoachListDTO;
import com.marnaud.gaming_coach_booking.entity.Coach;
import com.marnaud.gaming_coach_booking.entity.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoachMapper {

    CoachDTO toDTO(Coach coach);

    List<CoachDTO> toDTOList(List<Coach> coaches);

    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "games", target = "games", qualifiedByName = "gamesToNames")
    CoachListDTO toListDTO(Coach coach);

    @Mapping(source = "AppUser.username", target = "username")
    @Mapping(source = "games", target = "games", qualifiedByName = "gamesToNames")
    List<CoachListDTO> toListDTO(List<Coach> coach);

    @Named("gamesToNames")
    default List<String> gamesToNames(List<Game> games) {
        return games.stream().map(Game::getName).toList();
    }
}
