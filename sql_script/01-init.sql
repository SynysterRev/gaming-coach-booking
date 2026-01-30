DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS coach;
DROP TABLE IF EXISTS gamer;

CREATE TABLE app_user
(
    id         SERIAL PRIMARY KEY,
    username   VARCHAR(100) UNIQUE NOT NULL,
    email      VARCHAR(100) UNIQUE NOT NULL,
    password   VARCHAR(68)         NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT NULL
);


CREATE TABLE role
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE user_role
(
    user_id int NOT NULL,
    role_id int NOT NULL,

    PRIMARY KEY (user_id, role_id),

    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES app_user (id),

    CONSTRAINT fk_role
        FOREIGN KEY (role_id)
            REFERENCES role (id)
);

CREATE TABLE coach
(
    id          SERIAL PRIMARY KEY,
    hourly_rate NUMERIC(6, 2) NOT NULL,
    bio         TEXT,
    user_id     int           NOT NULL UNIQUE,
    updated_at TIMESTAMP DEFAULT NULL,

    CONSTRAINT fk_user_coach
        FOREIGN KEY (user_id)
            REFERENCES app_user (id)
);

CREATE TABLE gamer
(
    id      SERIAL PRIMARY KEY,
    user_id int NOT NULL UNIQUE,
    updated_at TIMESTAMP DEFAULT NULL,

    CONSTRAINT fk_user_gamer
        FOREIGN KEY (user_id)
            REFERENCES app_user (id)
);

INSERT INTO role(name)
VALUES ('ROLE_COACH'),
       ('ROLE_GAMER'),
       ('ROLE_ADMIN')
