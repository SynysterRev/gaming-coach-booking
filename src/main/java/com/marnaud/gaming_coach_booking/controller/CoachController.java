package com.marnaud.gaming_coach_booking.controller;

import com.marnaud.gaming_coach_booking.dto.CoachDTO;
import com.marnaud.gaming_coach_booking.dto.CoachListDTO;
import com.marnaud.gaming_coach_booking.dto.PagedResponse;
import com.marnaud.gaming_coach_booking.entity.Coach;
import com.marnaud.gaming_coach_booking.service.CoachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/coaches")
public class CoachController {
    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("")
    public PagedResponse<CoachListDTO> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort,
            @RequestParam(required = false) String gameName
    ) {
        String sortField = sort[0];
        Sort.Direction direction = (sort.length > 1 && sort[1].equalsIgnoreCase("desc"))
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortField));
        Page<CoachListDTO> coachPage = coachService.getAll(gameName, pageable);
        return new PagedResponse<CoachListDTO>(
                coachPage.getContent(),
                coachPage.getNumber(),
                coachPage.getSize(),
                coachPage.getTotalElements(),
                coachPage.getTotalPages(),
                coachPage.isLast()
        );
    }
}
