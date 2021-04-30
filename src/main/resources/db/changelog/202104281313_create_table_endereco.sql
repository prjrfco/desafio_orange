--liquibase formatted sql

--changeset bob:1

create table endereco
(
    id bigserial,
    usuario_id bigserial references usuario (id) match simple on update cascade on delete cascade,
    cep varchar(9),
    logradouro varchar(120),
    complemento varchar(120),
    bairro varchar(120),
    estado varchar(5),
    numero varchar(12),
    cidade varchar(120),
    primary key (id)
);