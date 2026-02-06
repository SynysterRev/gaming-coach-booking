package com.marnaud.gaming_coach_booking.mapper;

import com.marnaud.gaming_coach_booking.dto.CoachDTO;
import com.marnaud.gaming_coach_booking.entity.Coach;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoachMapper {

    CoachDTO toDTO(Coach coach);
    List<CoachDTO> toDTOList(List<Coach> coaches);
}
