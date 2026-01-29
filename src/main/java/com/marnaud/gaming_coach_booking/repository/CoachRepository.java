package com.marnaud.gaming_coach_booking.repository;

import com.marnaud.gaming_coach_booking.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}
