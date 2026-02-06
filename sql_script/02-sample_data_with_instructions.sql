-- Popular games
INSERT INTO game (name, genre, details)
VALUES 
    ('League of Legends', 'MOBA', 'Jeu d''arène de combat multijoueur en ligne développé par Riot Games'),
    ('Valorant', 'FPS', 'Jeu de tir tactique en 5v5 développé par Riot Games'),
    ('Counter-Strike 2', 'FPS', 'Jeu de tir tactique compétitif développé par Valve'),
    ('Dota 2', 'MOBA', 'Jeu d''arène de combat multijoueur développé par Valve'),
    ('Fortnite', 'Battle Royale', 'Jeu de survie et construction développé par Epic Games'),
    ('Overwatch 2', 'FPS', 'Jeu de tir en équipe basé sur des héros développé par Blizzard'),
    ('Rocket League', 'Sports', 'Jeu de football avec des voitures développé par Psyonix'),
    ('Rainbow Six Siege', 'FPS', 'Jeu de tir tactique développé par Ubisoft'),
    ('Apex Legends', 'Battle Royale', 'Jeu de tir battle royale développé par Respawn Entertainment'),
    ('StarCraft II', 'RTS', 'Jeu de stratégie en temps réel développé par Blizzard');

-- gamers
INSERT INTO gamer (id) VALUES 
    (1), (2), (3), (4), (5);

-- coaches
INSERT INTO coach (id, hourly_rate, bio)
VALUES 
    (1, 35.00, 'Ex-pro League of Legends, spécialisé en mid lane. 5 ans d''expérience en coaching.'),
    (2, 45.00, 'Coach Valorant. Expert en stratégies d''équipe et positioning. Plus de 200 élèves formés.'),
    (3, 30.00, 'Passionné de CS2 depuis CS 1.6. Focus sur l''aim training et la game sense.'),
    (4, 50.00, 'Coach professionnel Dota 2. Ancien joueur en équipe semi-pro. Spécialiste support et shotcalling.'),
    (5, 25.00, 'Streamer Fortnite avec 50k followers. Expert en build fights et stratégies de late game.'),
    (6, 40.00, 'Coach multi-jeux FPS. Spécialisé Overwatch 2 et Apex Legends. Ancien coach d''équipe esport.'),
    (7, 28.00, 'Champion Rocket League Grand Champion depuis 3 saisons. Focus sur les mécaniques et rotations.'),
    (8, 38.00, 'Ex-joueur pro Rainbow Six Siege. Expert en stratégies défensives et callouts.'),
    (9, 42.00, 'Coach Apex Legends. Spécialiste en movement et gunfights. Coaching personnalisé.'),
    (10, 35.00, 'Joueur Master StarCraft II en Terran. 10 ans d''expérience. Expert en macro et micro management.');

INSERT INTO app_user (username, email, password, coach_id, gamer_id)
VALUES 
    ('ProMidLaner', 'promid@gaming.com', '$2a$10$4fClVpuv1/e7Fgttk1QDHucbwtKAg3Znq6n3wVctA7WDykWPhyAia', 1, NULL),
    ('ValorantSensei', 'valocoach@gaming.com', '$2a$10$bMnBgKcyGK2wk0YqIqwwsOGmhQ/zTjibKg9OThFIcfLS2t0PNLd1e', 2, NULL),
    ('CS2Master', 'cs2pro@gaming.com', '$2a$10$D1kshXbsGyXqKlHDfofEU.bCspfASYDT5osnDV6WQvJFjdPlaSc2K', 3, NULL),
    ('DotaGuru', 'dotaguru@gaming.com', '$2a$10$Nh4x2FmUH5.uVZ/HuUGgJehzC1Wh03N.WmdeN34C1Zl8qq8GB4trK', 4, NULL),
    ('FortniteKing', 'fncoach@gaming.com', '$2a$10$bkUOWu8.MX3RtAvUWp79fumFQp2wWe6oPwAgtBN9Wr1r0otV.lQSa', 5, NULL),
    ('FPSCoach', 'fpsexpert@gaming.com', '$2a$10$5HeD8kry7GVqZ.pZNBUVVecn1b7SxInVLa0CplAa2pCxTIMhIis3S', 6, NULL),
    ('RocketChamp', 'rlcoach@gaming.com', '$2a$10$2YaDRLN3DrOGeowjeCbmpejHgnTd6RfXWRIfJZgwTU57cPM9nfcV.', 7, NULL),
    ('SiegeStrat', 'r6coach@gaming.com', '$2a$10$6HvKaeVR4QpNFOHeHNAsBeQ.prUaav1jpA5nkGMtE4J/DZPcWUFkK', 8, NULL),
    ('ApexPredator', 'apexcoach@gaming.com', '$2a$10$JT1mQ18tm6Y3xU4EVHFYjO6rmCnGJdFEBHsNsDqFzXASWDynlBlmu', 9, NULL),
    ('StarCraftPro', 'sc2coach@gaming.com', '$2a$10$0LW5C34KkI825xeFqLSvFOlvUMVIBpfbo3oYl5QSQKRLhYvqJdwR.', 10, NULL);

INSERT INTO app_user (username, email, password, coach_id, gamer_id)
VALUES 
    ('GamerBoy123', 'gamer1@email.com', '$2a$10$DVVjNLdN8LBorb2NGMwvyeiWguJ1o5ejOuRY9J/EBEc38N1tlHrZC', NULL, 1),
    ('ProWannabe', 'gamer2@email.com', '$2a$10$/nPIJ0EDLalGWeLo6Wt2MuWzYe0zdudiElaaATT1T22eD.LRBZY8e', NULL, 2),
    ('NoobSlayer', 'gamer3@email.com', '$2a$10$xbp6IRAjXDcOhFAiGfSYweUw5DMgegPGeJu9ejDLbfKSwcmvwSJJe', NULL, 3),
    ('TryHardGamer', 'gamer4@email.com', '$2a$10$C7mVHkQ0bg5a9HacNlK8oe5Rj15r3ODDi01MnTn8fZT9f/tznRVga', NULL, 4),
    ('CasualPlayer', 'gamer5@email.com', '$2a$10$hOguT80o.WhCqbE5VXIHW.qBs3nix4WPxMIJBEfW1DRFgupg9aak.', NULL, 5);

INSERT INTO user_role (user_id, role_id)
SELECT u.id, r.id 
FROM app_user u, role r
WHERE u.coach_id IS NOT NULL 
  AND r.name = 'ROLE_COACH';

INSERT INTO user_role (user_id, role_id)
SELECT u.id, r.id 
FROM app_user u, role r
WHERE u.gamer_id IS NOT NULL 
  AND r.name = 'ROLE_GAMER';

INSERT INTO coach_game (coach_id, game_id)
VALUES 
    -- ProMidLaner (League of Legends)
    (1, 1),
    -- ValorantSensei (Valorant)
    (2, 2),
    -- CS2Master (CS2, Valorant)
    (3, 3), (3, 2),
    -- DotaGuru (Dota 2)
    (4, 4),
    -- FortniteKing (Fortnite, Apex)
    (5, 5), (5, 9),
    -- FPSCoach (Overwatch, Apex, Valorant)
    (6, 6), (6, 9), (6, 2),
    -- RocketChamp (Rocket League)
    (7, 7),
    -- SiegeStrat (Rainbow Six)
    (8, 8),
    -- ApexPredator (Apex, Overwatch)
    (9, 9), (9, 6),
    -- StarCraftPro (StarCraft II)
    (10, 10);


-- League of Legends Ranks (rank_order: lower = better)
INSERT INTO game_rank (name, rank_order, game_id)
VALUES
    ('Iron', 9, (SELECT id FROM game WHERE name = 'League of Legends')),
    ('Bronze', 8, (SELECT id FROM game WHERE name = 'League of Legends')),
    ('Silver', 7, (SELECT id FROM game WHERE name = 'League of Legends')),
    ('Gold', 6, (SELECT id FROM game WHERE name = 'League of Legends')),
    ('Platinum', 5, (SELECT id FROM game WHERE name = 'League of Legends')),
    ('Emerald', 4, (SELECT id FROM game WHERE name = 'League of Legends')),
    ('Diamond', 3, (SELECT id FROM game WHERE name = 'League of Legends')),
    ('Master', 2, (SELECT id FROM game WHERE name = 'League of Legends')),
    ('Grandmaster', 1, (SELECT id FROM game WHERE name = 'League of Legends')),
    ('Challenger', 0, (SELECT id FROM game WHERE name = 'League of Legends'));

-- Valorant Ranks
INSERT INTO game_rank (name, rank_order, game_id)
VALUES
    ('Iron', 8, (SELECT id FROM game WHERE name = 'Valorant')),
    ('Bronze', 7, (SELECT id FROM game WHERE name = 'Valorant')),
    ('Silver', 6, (SELECT id FROM game WHERE name = 'Valorant')),
    ('Gold', 5, (SELECT id FROM game WHERE name = 'Valorant')),
    ('Platinum', 4, (SELECT id FROM game WHERE name = 'Valorant')),
    ('Diamond', 3, (SELECT id FROM game WHERE name = 'Valorant')),
    ('Ascendant', 2, (SELECT id FROM game WHERE name = 'Valorant')),
    ('Immortal', 1, (SELECT id FROM game WHERE name = 'Valorant')),
    ('Radiant', 0, (SELECT id FROM game WHERE name = 'Valorant'));

-- Counter-Strike 2 Ranks
INSERT INTO game_rank (name, rank_order, game_id)
VALUES
    ('Silver I', 17, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Silver II', 16, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Silver III', 15, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Silver IV', 14, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Silver Elite', 13, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Silver Elite Master', 12, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Gold Nova I', 11, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Gold Nova II', 10, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Gold Nova III', 9, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Gold Nova Master', 8, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Master Guardian I', 7, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Master Guardian II', 6, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Master Guardian Elite', 5, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Distinguished Master Guardian', 4, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Legendary Eagle', 3, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Legendary Eagle Master', 2, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Supreme Master First Class', 1, (SELECT id FROM game WHERE name = 'Counter-Strike 2')),
    ('Global Elite', 0, (SELECT id FROM game WHERE name = 'Counter-Strike 2'));

-- Dota 2 Ranks
INSERT INTO game_rank (name, rank_order, game_id)
VALUES
    ('Herald', 7, (SELECT id FROM game WHERE name = 'Dota 2')),
    ('Guardian', 6, (SELECT id FROM game WHERE name = 'Dota 2')),
    ('Crusader', 5, (SELECT id FROM game WHERE name = 'Dota 2')),
    ('Archon', 4, (SELECT id FROM game WHERE name = 'Dota 2')),
    ('Legend', 3, (SELECT id FROM game WHERE name = 'Dota 2')),
    ('Ancient', 2, (SELECT id FROM game WHERE name = 'Dota 2')),
    ('Divine', 1, (SELECT id FROM game WHERE name = 'Dota 2')),
    ('Immortal', 0, (SELECT id FROM game WHERE name = 'Dota 2'));

-- Fortnite Ranks (système Arena)
INSERT INTO game_rank (name, rank_order, game_id)
VALUES
    ('Open League', 10, (SELECT id FROM game WHERE name = 'Fortnite')),
    ('Bronze I', 9, (SELECT id FROM game WHERE name = 'Fortnite')),
    ('Bronze II', 8, (SELECT id FROM game WHERE name = 'Fortnite')),
    ('Bronze III', 7, (SELECT id FROM game WHERE name = 'Fortnite')),
    ('Silver I', 6, (SELECT id FROM game WHERE name = 'Fortnite')),
    ('Silver II', 5, (SELECT id FROM game WHERE name = 'Fortnite')),
    ('Silver III', 4, (SELECT id FROM game WHERE name = 'Fortnite')),
    ('Gold I', 3, (SELECT id FROM game WHERE name = 'Fortnite')),
    ('Gold II', 2, (SELECT id FROM game WHERE name = 'Fortnite')),
    ('Gold III', 1, (SELECT id FROM game WHERE name = 'Fortnite')),
    ('Champion League', 0, (SELECT id FROM game WHERE name = 'Fortnite'));

-- Overwatch 2 Ranks
INSERT INTO game_rank (name, rank_order, game_id)
VALUES
    ('Bronze', 6, (SELECT id FROM game WHERE name = 'Overwatch 2')),
    ('Silver', 5, (SELECT id FROM game WHERE name = 'Overwatch 2')),
    ('Gold', 4, (SELECT id FROM game WHERE name = 'Overwatch 2')),
    ('Platinum', 3, (SELECT id FROM game WHERE name = 'Overwatch 2')),
    ('Diamond', 2, (SELECT id FROM game WHERE name = 'Overwatch 2')),
    ('Master', 1, (SELECT id FROM game WHERE name = 'Overwatch 2')),
    ('Grandmaster', 0, (SELECT id FROM game WHERE name = 'Overwatch 2'));

-- Rocket League Ranks
INSERT INTO game_rank (name, rank_order, game_id)
VALUES
    ('Bronze I', 21, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Bronze II', 20, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Bronze III', 19, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Silver I', 18, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Silver II', 17, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Silver III', 16, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Gold I', 15, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Gold II', 14, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Gold III', 13, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Platinum I', 12, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Platinum II', 11, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Platinum III', 10, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Diamond I', 9, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Diamond II', 8, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Diamond III', 7, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Champion I', 6, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Champion II', 5, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Champion III', 4, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Grand Champion I', 3, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Grand Champion II', 2, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Grand Champion III', 1, (SELECT id FROM game WHERE name = 'Rocket League')),
    ('Supersonic Legend', 0, (SELECT id FROM game WHERE name = 'Rocket League'));

-- Rainbow Six Siege Ranks
INSERT INTO game_rank (name, rank_order, game_id)
VALUES
    ('Copper V', 35, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Copper IV', 34, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Copper III', 33, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Copper II', 32, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Copper I', 31, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Bronze V', 30, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Bronze IV', 29, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Bronze III', 28, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Bronze II', 27, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Bronze I', 26, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Silver V', 25, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Silver IV', 24, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Silver III', 23, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Silver II', 22, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Silver I', 21, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Gold V', 20, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Gold IV', 19, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Gold III', 18, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Gold II', 17, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Gold I', 16, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Platinum V', 15, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Platinum IV', 14, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Platinum III', 13, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Platinum II', 12, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Platinum I', 11, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Emerald V', 10, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Emerald IV', 9, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Emerald III', 8, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Emerald II', 7, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Emerald I', 6, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Diamond V', 5, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Diamond IV', 4, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Diamond III', 3, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Diamond II', 2, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Diamond I', 1, (SELECT id FROM game WHERE name = 'Rainbow Six Siege')),
    ('Champion', 0, (SELECT id FROM game WHERE name = 'Rainbow Six Siege'));

-- Apex Legends Ranks
INSERT INTO game_rank (name, rank_order, game_id)
VALUES
    ('Rookie', 7, (SELECT id FROM game WHERE name = 'Apex Legends')),
    ('Bronze', 6, (SELECT id FROM game WHERE name = 'Apex Legends')),
    ('Silver', 5, (SELECT id FROM game WHERE name = 'Apex Legends')),
    ('Gold', 4, (SELECT id FROM game WHERE name = 'Apex Legends')),
    ('Platinum', 3, (SELECT id FROM game WHERE name = 'Apex Legends')),
    ('Diamond', 2, (SELECT id FROM game WHERE name = 'Apex Legends')),
    ('Master', 1, (SELECT id FROM game WHERE name = 'Apex Legends')),
    ('Predator', 0, (SELECT id FROM game WHERE name = 'Apex Legends'));

-- StarCraft II Ranks
INSERT INTO game_rank (name, rank_order, game_id)
VALUES
    ('Bronze', 6, (SELECT id FROM game WHERE name = 'StarCraft II')),
    ('Silver', 5, (SELECT id FROM game WHERE name = 'StarCraft II')),
    ('Gold', 4, (SELECT id FROM game WHERE name = 'StarCraft II')),
    ('Platinum', 3, (SELECT id FROM game WHERE name = 'StarCraft II')),
    ('Diamond', 2, (SELECT id FROM game WHERE name = 'StarCraft II')),
    ('Master', 1, (SELECT id FROM game WHERE name = 'StarCraft II')),
    ('Grandmaster', 0, (SELECT id FROM game WHERE name = 'StarCraft II'));


-- ============================================================
-- COACH-GAME-RANK ASSOCIATIONS
-- ============================================================

-- Coach 1: League of Legends - Diamond
INSERT INTO coach_game_rank (coach_id, game_id, rank_id)
VALUES (1,
        (SELECT id FROM game WHERE name = 'League of Legends'),
        (SELECT id FROM game_rank WHERE name = 'Diamond' AND game_id = (SELECT id FROM game WHERE name = 'League of Legends')));

-- Coach 2: Valorant - Radiant
INSERT INTO coach_game_rank (coach_id, game_id, rank_id)
VALUES (2,
        (SELECT id FROM game WHERE name = 'Valorant'),
        (SELECT id FROM game_rank WHERE name = 'Radiant' AND game_id = (SELECT id FROM game WHERE name = 'Valorant')));

-- Coach 3: Counter-Strike 2 - Global Elite (équivalent FaceIT 10)
INSERT INTO coach_game_rank (coach_id, game_id, rank_id)
VALUES (3,
        (SELECT id FROM game WHERE name = 'Counter-Strike 2'),
        (SELECT id FROM game_rank WHERE name = 'Global Elite' AND game_id = (SELECT id FROM game WHERE name = 'Counter-Strike 2')));

-- Coach 4: Dota 2 - Divine (semi-pro level)
INSERT INTO coach_game_rank (coach_id, game_id, rank_id)
VALUES (4,
        (SELECT id FROM game WHERE name = 'Dota 2'),
        (SELECT id FROM game_rank WHERE name = 'Divine' AND game_id = (SELECT id FROM game WHERE name = 'Dota 2')));

-- Coach 5: Fortnite - Champion League
INSERT INTO coach_game_rank (coach_id, game_id, rank_id)
VALUES (5,
        (SELECT id FROM game WHERE name = 'Fortnite'),
        (SELECT id FROM game_rank WHERE name = 'Champion League' AND game_id = (SELECT id FROM game WHERE name = 'Fortnite')));

-- Coach 6: Overwatch 2 - Master + Apex Legends - Master
INSERT INTO coach_game_rank (coach_id, game_id, rank_id)
VALUES
    (6,
     (SELECT id FROM game WHERE name = 'Overwatch 2'),
     (SELECT id FROM game_rank WHERE name = 'Master' AND game_id = (SELECT id FROM game WHERE name = 'Overwatch 2'))),
    (6,
     (SELECT id FROM game WHERE name = 'Apex Legends'),
     (SELECT id FROM game_rank WHERE name = 'Master' AND game_id = (SELECT id FROM game WHERE name = 'Apex Legends')));

-- Coach 7: Rocket League - Grand Champion III
INSERT INTO coach_game_rank (coach_id, game_id, rank_id)
VALUES (7,
        (SELECT id FROM game WHERE name = 'Rocket League'),
        (SELECT id FROM game_rank WHERE name = 'Grand Champion III' AND game_id = (SELECT id FROM game WHERE name = 'Rocket League')));

-- Coach 8: Rainbow Six Siege - Diamond I (ex-pro)
INSERT INTO coach_game_rank (coach_id, game_id, rank_id)
VALUES (8,
        (SELECT id FROM game WHERE name = 'Rainbow Six Siege'),
        (SELECT id FROM game_rank WHERE name = 'Diamond I' AND game_id = (SELECT id FROM game WHERE name = 'Rainbow Six Siege')));

-- Coach 9: Apex Legends - Predator
INSERT INTO coach_game_rank (coach_id, game_id, rank_id)
VALUES (9,
        (SELECT id FROM game WHERE name = 'Apex Legends'),
        (SELECT id FROM game_rank WHERE name = 'Predator' AND game_id = (SELECT id FROM game WHERE name = 'Apex Legends')));

-- Coach 10: StarCraft II - Master
INSERT INTO coach_game_rank (coach_id, game_id, rank_id)
VALUES (10,
        (SELECT id FROM game WHERE name = 'StarCraft II'),
        (SELECT id FROM game_rank WHERE name = 'Master' AND game_id = (SELECT id FROM game WHERE name = 'StarCraft II')));