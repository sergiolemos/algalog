create table cliente(
    id serial not null,
    nome varchar not null,
    email varchar(150) not null,
    telefone varchar(20),

    primary key (id)
);