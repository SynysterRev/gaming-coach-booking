DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS coach;
DROP TABLE IF EXISTS gamer;

CREATE TABLE coach
(
    id          BIGSERIAL PRIMARY KEY,
    hourly_rate NUMERIC(6, 2),
    bio         TEXT,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT NULL
);

CREATE TABLE gamer
(
    id         BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE app_user
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(100) UNIQUE NOT NULL,
    email      VARCHAR(100) UNIQUE NOT NULL,
    password   VARCHAR(68)         NOT NULL,
    coach_id   BIGINT    DEFAULT NULL,
    gamer_id   BIGINT    DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT NULL,

    CONSTRAINT fk_user_coach FOREIGN KEY (coach_id)
        REFERENCES coach (id) ON DELETE SET NULL,
    CONSTRAINT fk_user_gamer FOREIGN KEY (gamer_id)
        REFERENCES gamer (id) ON DELETE SET NULL
);


CREATE TABLE role
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE user_role
(
    user_id BIGSERIAL NOT NULL,
    role_id BIGSERIAL NOT NULL,

    PRIMARY KEY (user_id, role_id),

    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES app_user (id) ON DELETE CASCADE,

    CONSTRAINT fk_role
        FOREIGN KEY (role_id)
            REFERENCES role (id) ON DELETE CASCADE
);

CREATE TABLE game
(
    id      BIGSERIAL PRIMARY KEY,
    name    VARCHAR(150) UNIQUE NOT NULL,
    genre   VARCHAR(100)        NOT NULL,
    details TEXT
);

CREATE TABLE coaching_slot
(
    id         BIGSERIAL PRIMARY KEY,
    coach_id   BIGINT    NOT NULL,
    game_id    BIGINT,
    start_time TIMESTAMP NOT NULL,
    end_time   TIMESTAMP NOT NULL,
    status     VARCHAR(20) DEFAULT 'AVAILABLE', -- AVAILABLE, BOOKED, COMPLETED, CANCELLED
    gamer_id   BIGINT,                          -- NULL if not booked
    created_at TIMESTAMP   DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE game_rank
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    rank_order INT,
    game_id    BIGINT      NOT NULL,
    CONSTRAINT fk_game
        FOREIGN KEY (game_id)
            REFERENCES game (id) ON DELETE CASCADE
);

CREATE TABLE coach_game_rank
(
    id       BIGSERIAL PRIMARY KEY,
    coach_id BIGINT NOT NULL,
    game_id  BIGINT NOT NULL,
    rank_id  BIGINT NOT NULL,
    UNIQUE (coach_id, game_id),
    CONSTRAINT fk_game
        FOREIGN KEY (game_id)
            REFERENCES game (id) ON DELETE CASCADE,
    CONSTRAINT fk_coach
        FOREIGN KEY (coach_id)
            REFERENCES coach (id) ON DELETE CASCADE,
    CONSTRAINT fk_rank
        FOREIGN KEY (rank_id)
            REFERENCES game_rank (id) ON DELETE CASCADE
);

INSERT INTO role(name)
VALUES ('ROLE_COACH'),
       ('ROLE_GAMER'),
       ('ROLE_ADMIN')
