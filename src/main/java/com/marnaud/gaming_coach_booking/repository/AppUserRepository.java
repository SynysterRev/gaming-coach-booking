package com.marnaud.gaming_coach_booking.repository;

import com.marnaud.gaming_coach_booking.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    @Query("SELECT u FROM AppUser u LEFT JOIN FETCH u.roles WHERE u.email = :email")
    Optional<AppUser> findByEmailWithRole(@Param("email") String email);
    Optional<AppUser> findByUsername(String username);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
