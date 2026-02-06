package com.marnaud.gaming_coach_booking.repository;

import com.marnaud.gaming_coach_booking.entity.Coach;
import com.marnaud.gaming_coach_booking.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    @Query("SELECT c FROM Coach c LEFT JOIN FETCH c.user")
    List<Coach> findAllWithUser();

    @Query("SELECT c FROM Coach c LEFT JOIN FETCH c.user LEFT JOIN FETCH c.gameRanks")
    Page<Coach> findAllWithUserAndGames(Pageable pageable);

//    @Query("SELECT DISTINCT c FROM Coach c " +
//            "LEFT JOIN FETCH c.user " +
//            "LEFT JOIN FETCH c.gameRanks g " +
//            "WHERE LOWER(g.name) LIKE LOWER(CONCAT('%', ?1, '%'))")
//    Page<Coach> findCoachesByGamesContainingIgnoreCase(String gameName, Pageable pageable);
}
