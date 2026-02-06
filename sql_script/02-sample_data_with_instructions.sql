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
    (1, 35.00, 'Ex-pro League of Legends, spécialisé en mid lane. 5 ans d''expérience en coaching, ancien Diamant 1.'),
    (2, 45.00, 'Coach Valorant certifié Radiant. Expert en stratégies d''équipe et positioning. Plus de 200 élèves formés.'),
    (3, 30.00, 'Passionné de CS2 depuis CS 1.6. Focus sur l''aim training et la game sense. Niveau FaceIT 10.'),
    (4, 50.00, 'Coach professionnel Dota 2. Ancien joueur en équipe semi-pro. Spécialiste support et shotcalling.'),
    (5, 25.00, 'Streamer Fortnite avec 50k followers. Expert en build fights et stratégies de late game.'),
    (6, 40.00, 'Coach multi-jeux FPS. Spécialisé Overwatch 2 et Apex Legends. Ancien coach d''équipe esport.'),
    (7, 28.00, 'Champion Rocket League Grand Champion depuis 3 saisons. Focus sur les mécaniques et rotations.'),
    (8, 38.00, 'Ex-joueur pro Rainbow Six Siege. Expert en stratégies défensives et callouts.'),
    (9, 42.00, 'Coach Apex Legends Predator. Spécialiste en movement et gunfights. Coaching personnalisé.'),
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
