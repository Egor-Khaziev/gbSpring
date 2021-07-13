DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE IF NOT EXISTS product (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO product (title, price) VALUES
('toy', 100),
('ball', 150),
('pen', 20),
('pencil', 10);