DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES
('toy', 100),
('ball', 150),
('pen', 20),
('pencil', 10);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO users (name) VALUES
('Queen Joanna'),
('dr.Smith'),
('King Albert'),
('Harry Potter'),
('Da Vinci'),
('Lord of the Ring');

DROP TABLE IF EXISTS users_products CASCADE;
CREATE TABLE users_products (user_id bigint, product_id bigint, FOREIGN KEY (user_id) REFERENCES users (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO users_products (user_id, product_id) VALUES
(1, 2),
(2, 1),
(3, 1),
(4, 4),
(5, 1),
(6, 1),
(1, 3),
(2, 2),
(3, 4),
(4, 2);