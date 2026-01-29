package com.marnaud.gaming_coach_booking.repository;

import com.marnaud.gaming_coach_booking.entity.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerRepository extends JpaRepository<Gamer, Long> {
}
