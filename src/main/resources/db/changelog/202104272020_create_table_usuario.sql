--liquibase formatted sql

--changeset bob:1

create table usuario
(
    id bigserial,
    nome varchar(120) not null,
    email varchar(255) not null unique,
    cpf varchar(11) not null unique ,
    data_nascimento date not null,
    primary key (id)
);