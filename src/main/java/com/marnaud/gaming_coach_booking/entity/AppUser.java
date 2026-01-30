package com.marnaud.gaming_coach_booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "app_user")
public class AppUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Coach coach;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Gamer gamer;

    public void setCoach(Coach coach) {
        this.coach = coach;
        if (coach != null) {
            coach.setUser(this);
        }
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
        if (gamer != null) {
            gamer.setUser(this);
        }
    }

    public void addRole(Role role) {
        if (roles == null) {
            roles = new ArrayList<>();
        }

        roles.add(role);
    }
}
