create table doctors (
    id binary not null,
    login varchar(255),
    password varchar(255),
    npwz varchar(7),
    firstName varchar(255),
    lastName varchar(255),
    specialization varchar(255),
    user_type varchar(30),
    primary key (npwz));