create sequence pedido_seq start 100 increment 1;

create table produto (
    id int not null,
    categoria varchar(1000) not null,
    descricao varchar(1000) not null,
    preco decimal(8, 2) not null,
    constraint produto_pk primary key (id)
);

create table pedido (
    id int not null,
    data_hora datetime not null,
    situacao varchar(100) not null,
    constraint pedido_pk primary key (id)
);

create table item_pedido (
    id_pedido int not null,
    id_produto int not null,
    quantidade int not null,
    constraint item_pedido_pk primary key (id_pedido, id_produto)
);

alter table item_pedido add constraint item_pedido_fk1 foreign key (id_pedido) references pedido(id) on delete cascade;
alter table item_pedido add constraint item_pedido_fk2 foreign key (id_produto) references produto(id) on delete restrict;