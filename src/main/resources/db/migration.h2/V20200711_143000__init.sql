create table users (
    id binary not null,
    login varchar(255),
    password varchar(255),
    name varchar(255),
    pesel int (10),
    surname varchar(255),
    primary key (id));