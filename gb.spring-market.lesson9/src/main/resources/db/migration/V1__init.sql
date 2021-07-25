create table categories
(
    id         bigserial primary key,
    title      varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into categories (title) values ('Food'), ('Toys'), ('Other');

create table products
(
    id          bigserial primary key,
    title       varchar(255),
    price       int,
    category_id bigint references categories (id),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

INSERT INTO products (title, price, category_id) VALUES
('toy', 100, 1),
('ball', 150, 1),
('pen', 250, 1),
('toy1', 450, 2),
('ball1', 150, 3),
('pen1', 250, 1),
('toy2', 120, 2),
('ball2', 120, 2),
('toy3', 130, 2),
('ball3', 130, 2),
('pen3', 300, 1),
('toy4', 100, 3),
('ball4', 1500, 2),
('pen4', 2000, 1),
('toy5', 1000, 2),
('ball5', 15, 1),
('pen5', 20, 2),
('toy6', 80, 1),
('ball6', 150, 2),
('toy4', 100, 3),
('ball4', 1500, 2),
('pen4', 2000, 1),
('toy5', 1000, 2),
('ball5', 15, 1),
('pen5', 20, 2),
('toy6', 80, 1),
('ball6', 150, 2),
('pencil', 10, 3);

create table users
(
    id          bigserial primary key,
    name       varchar(255),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

INSERT INTO users (name) VALUES
('British Queen'),
('dr.Jekyll'),
('King Albert'),
('Harry Potter'),
('Da Vinci'),
('Hercule Poirot'),
('Aphrodite'),
('Lord of the Ring');

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