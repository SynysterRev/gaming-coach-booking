package com.marnaud.gaming_coach_booking.service;

import com.marnaud.gaming_coach_booking.dto.CoachDTO;
import com.marnaud.gaming_coach_booking.dto.CoachListDTO;
import com.marnaud.gaming_coach_booking.entity.Coach;
import com.marnaud.gaming_coach_booking.mapper.CoachMapper;
import com.marnaud.gaming_coach_booking.repository.CoachRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {
    private final CoachRepository coachRepository;
    private final CoachMapper coachMapper;

    public CoachService(CoachRepository coachRepository, CoachMapper coachMapper) {
        this.coachRepository = coachRepository;
        this.coachMapper = coachMapper;
    }

    public Page<CoachListDTO> getAll(String gameName, Pageable pageable) {
        Page<Coach> coaches;
//        if (gameName != null && !gameName.isEmpty()) {
//            coaches = coachRepository.findCoachesByGamesContainingIgnoreCase(gameName, pageable);
//        } else {
//            coaches = coachRepository.findAllWithUserAndGames(pageable);
//        }
        coaches = coachRepository.findAllWithUserAndGames(pageable);
        return coaches.map(coachMapper::toListDTO);
    }
}
