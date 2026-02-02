package com.marnaud.gaming_coach_booking.mapper;

import com.marnaud.gaming_coach_booking.dto.GamerDTO;
import com.marnaud.gaming_coach_booking.entity.Gamer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-02T17:53:49+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class GamerMapperImpl implements GamerMapper {

    @Override
    public GamerDTO toDTO(Gamer gamer) {
        if ( gamer == null ) {
            return null;
        }

        GamerDTO gamerDTO = new GamerDTO();

        return gamerDTO;
    }
}
