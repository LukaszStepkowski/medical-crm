create table examination (
    id binary not null,
    type varchar(255) not null,
    result varchar(255) not null,
    picture_path varchar(255),
    description varchar(255) not null,
    primary key (id));

create table appointment (
    id binary not null,
    appointment_date datetime not null,
    patient varchar(255) not null,
    specialization varchar(255) not null,
    examinations varchar(255) not null,
    clinic varchar(255) not null,
    is_online boolean not null,
    prescription varchar(255) not null,
    primary key (id));

create table examination_appointment (
    examination_id binary not null,
    appointment_id binary not null)

