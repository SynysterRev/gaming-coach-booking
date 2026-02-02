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
    coach_id   int UNIQUE DEFAULT NULL,
    gamer_id   int UNIQUE DEFAULT NULL,
    created_at TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP  DEFAULT NULL,

    CONSTRAINT fk_user_coach FOREIGN KEY (coach_id)
        REFERENCES coach (id) ON DELETE SET NULL,
    CONSTRAINT fk_user_gamer FOREIGN KEY (gamer_id)
        REFERENCES gamer (id) ON DELETE SET NULL
);


CREATE TABLE role
(
    id BIGSERIAL PRIMARY KEY,
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

INSERT INTO role(name)
VALUES ('ROLE_COACH'),
       ('ROLE_GAMER'),
       ('ROLE_ADMIN')
