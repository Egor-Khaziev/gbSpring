DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), cost int, PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES
('toy', 100),
('ball', 150),
('pen', 250),
('toy1', 450),
('ball1', 150),
('pen1', 250),
('toy2', 120),
('ball2', 120),
('toy3', 130),
('ball3', 130),
('pen3', 300),
('toy4', 100),
('ball4', 1500),
('pen4', 2000),
('toy5', 1000),
('ball5', 15),
('pen5', 20),
('toy6', 80),
('ball6', 150),
('pencil', 10);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO users (name) VALUES
('British Queen'),
('dr.Jekyll'),
('King Albert'),
('Harry Potter'),
('Da Vinci'),
('Hercule Poirot'),
('Aphrodite'),
('Lord of the Ring');

DROP TABLE IF EXISTS users_products CASCADE;
CREATE TABLE users_products (user_id bigint, product_id bigint, FOREIGN KEY (user_id) REFERENCES users (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO users_products (user_id, product_id) VALUES
(1, 12),
(2, 1),
(3, 11),
(4, 4),
(5, 6),
(6, 1),
(1, 13),
(2, 2),
(3, 9),
(7, 1),
(7, 3),
(8, 18),
(8, 8),
(4, 2);