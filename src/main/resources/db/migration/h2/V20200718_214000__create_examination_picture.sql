create table pictures (
    id binary not null,
    picture_path varchar(255),
    primary key (id));

create table examinations_pictures (
    examination_id binary not null,
    pictures_id binary not null);