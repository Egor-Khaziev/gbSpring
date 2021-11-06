create table users (
    id          bigserial,
    username    varchar(30) unique not null,
    password    varchar(80) not null,
    email       varchar(40) unique,
    primary key (id)
);

create table roles (
    id          serial,
    name        varchar(60),
    primary key (id)
);

create table users_roles (
    user_id         bigint,
    role_id         int,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

insert into roles (name)
values ('ROLE_ADMIN') , ('ROLE_USER'), ('USERS_INFO'), ('BOOKS'), ('TEST'), ('GAMES'), ('FILMS');

insert into users (username, password, email)
values ('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@gmail.com'),
       ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com');;

insert into users_roles (user_id, role_id)
values (1,1), (1,3), (1,4), (1,5), (2,2), (2,6), (1,6), (2,7);