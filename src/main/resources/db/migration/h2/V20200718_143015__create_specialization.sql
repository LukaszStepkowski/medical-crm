create table specializations (
    id binary not null,
    type_of_specialization varchar(255),
    primary key (id));

create table specializations_users (
    specialization_id binary not null,
    user_id binary not null);

create table examinations_specializations (
    examination_id binary not null,
    specialization_id binary not null);
)
