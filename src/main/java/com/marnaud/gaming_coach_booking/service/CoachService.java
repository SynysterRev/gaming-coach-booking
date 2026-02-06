package com.marnaud.gaming_coach_booking.service;

import com.marnaud.gaming_coach_booking.dto.CoachDTO;
import com.marnaud.gaming_coach_booking.entity.Coach;
import com.marnaud.gaming_coach_booking.mapper.CoachMapper;
import com.marnaud.gaming_coach_booking.repository.CoachRepository;
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

    public List<CoachDTO> getAll() {
        List<Coach> coaches = coachRepository.findAll();
        return coachMapper.toDTOList(coaches);
    }
}
