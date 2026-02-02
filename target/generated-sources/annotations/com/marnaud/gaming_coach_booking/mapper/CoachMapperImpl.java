package com.marnaud.gaming_coach_booking.mapper;

import com.marnaud.gaming_coach_booking.dto.CoachDTO;
import com.marnaud.gaming_coach_booking.entity.Coach;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-02T11:56:30+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class CoachMapperImpl implements CoachMapper {

    @Override
    public CoachDTO toDTO(Coach coach) {
        if ( coach == null ) {
            return null;
        }

        String bio = null;
        BigDecimal hourlyRate = null;

        bio = coach.getBio();
        hourlyRate = coach.getHourlyRate();

        CoachDTO coachDTO = new CoachDTO( bio, hourlyRate );

        return coachDTO;
    }
}
