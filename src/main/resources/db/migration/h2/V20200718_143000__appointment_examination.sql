create table examinations (
    id binary not null,
    type varchar(255) not null,
    result varchar(255) not null,
    picture_path varchar(255),
    description varchar(255) not null,
    primary key (id));

create table appointments (
    id binary not null,
    appointment_date datetime not null,
    clinic varchar(255) not null,
    is_online boolean not null,
    prescription varchar(255) not null,
    primary key (id));

create table appointments_examinations (
    appointment_id binary not null,
    examination_id binary not null);

create table appointments_users (
    appointment_id binary not null,
    user_id binary not null);

create table appointments_specializations (
    appointment_id binary not null,
    specialization_id binary not null);

