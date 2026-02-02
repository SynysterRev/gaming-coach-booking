package com.marnaud.gaming_coach_booking.mapper;

import com.marnaud.gaming_coach_booking.dto.GamerDTO;
import com.marnaud.gaming_coach_booking.entity.Gamer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GamerMapper {
    GamerDTO toDTO(Gamer gamer);
}
