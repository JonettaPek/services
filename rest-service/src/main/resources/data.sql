INSERT INTO user_details (id, name, birthdate) VALUES (10001, 'Sam', CURRENT_DATE());
INSERT INTO user_details (id, name, birthdate) VALUES (10002, 'Paul', CURRENT_DATE());
INSERT INTO user_details (id, name, birthdate) VALUES (10003, 'John', CURRENT_DATE());

INSERT INTO post (id, description, user_id) VALUES (1, 'today''s weather is very hot', 10001);
INSERT INTO post (id, description, user_id) VALUES (2, 'hope everyone has a great day', 10001);
INSERT INTO post (id, description, user_id) VALUES (3, 'can''t wait to start placement', 10002);
