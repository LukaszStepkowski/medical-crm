create table clinics (
    id binary not null,
    addresses_id binary not null,
    primary key (id));

create table prescriptions (
    id binary not null,
    prescription_no int not null,
    description varchar (255),
    primary key (id));

create table addresses (
    id binary not null,
    city varchar(255),
    country varchar(255),
    street varchar(255),
    zip_code varchar(255),
    primary key (id));

create table clinics_addresses (
    clinic_id binary not null,
    address_id binary not null)