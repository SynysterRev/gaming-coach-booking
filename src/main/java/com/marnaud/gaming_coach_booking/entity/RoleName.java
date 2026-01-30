package com.marnaud.gaming_coach_booking.entity;

public enum RoleName {
    ROLE_COACH,
    ROLE_GAMER,
    ROLE_ADMIN;

    @Override
    public String toString() {
        return name();
    }
}
