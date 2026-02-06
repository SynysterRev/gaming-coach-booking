package com.marnaud.gaming_coach_booking.repository;

import com.marnaud.gaming_coach_booking.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    @Query("SELECT c FROM Coach c LEFT JOIN FETCH c.user")
    List<Coach> findAllWithUser();

    @Query("SELECT c FROM Coach c LEFT JOIN FETCH c.user LEFT JOIN FETCH c.games")
    List<Coach> findAllWithUserAndGames();
}
