package com.marnaud.gaming_coach_booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "game_rank")
public class GameRank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rank_order")
    private int rankOrder;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;
}
