package com.marnaud.gaming_coach_booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "coach")
public class Coach extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "hourly_rate", precision = 6, scale = 2)
    private BigDecimal hourlyRate;

    @Column(name = "bio")
    private String bio;

    @OneToOne(mappedBy = "coach",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private AppUser user;
}
