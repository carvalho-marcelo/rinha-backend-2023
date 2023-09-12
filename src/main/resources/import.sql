drop table if exists pessoa cascade;

drop table if exists stack cascade;

create table if not exists pessoa (
    nascimento date not null,
    id uuid not null,
    apelido varchar(32) not null unique,
    nome varchar(100) not null,
    primary key (id)
);

create table if not exists stack (
    pessoa_id uuid not null,
    stack varchar(32)
);

alter table if exists stack
   foreign key (pessoa_id)
   references pessoa;

create index pessoa_nome_index on pessoa (nome);
create index pessoa_apelido_index on pessoa (apelido);