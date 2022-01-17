create table ocorrencia(
    id serial not null,
    entrega_id bigint not null,
    descricao varchar(200) not null,
    data_registro timestamp not null,

    primary key (id)
);

alter table ocorrencia add constraint fk_ocorrencia_entrega foreign key (entrega_id) references entrega (id);