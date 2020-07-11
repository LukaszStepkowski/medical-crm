create table users (
    id binary not null,
    login varchar(255),
    password varchar(255),
    name varchar(255),
    pesel int (10),
    npwz varchar(7),
    specialization varchar (255),
    surname varchar(255),
    user_type varchar(30),
    primary key (id));