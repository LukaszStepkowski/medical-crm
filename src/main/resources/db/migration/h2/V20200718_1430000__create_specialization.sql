create table specializations (
    id binary not null,
    type_of_specialization varchar(255),
    primary key (id));


create table users_specializations (
    users_id binary not null,
    specializations_id binary not null);

