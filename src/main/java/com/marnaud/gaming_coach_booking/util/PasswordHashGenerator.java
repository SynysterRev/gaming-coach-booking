package com.marnaud.gaming_coach_booking.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "password123"; // Mot de passe simple pour le dev
        System.out.println("Hash BCrypt for password: " + password);
        System.out.println("---------------------------------------------");

        // Generate 15 hash (10 coaches + 5 gamers)
        for (int i = 1; i <= 15; i++) {
            String hash = encoder.encode(password);
            System.out.println("-- User " + i + ":");
            System.out.println("'" + hash + "',");
        }
    }
}
