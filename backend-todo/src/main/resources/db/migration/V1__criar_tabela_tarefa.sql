create  EXTENSION IF NOT EXISTS "uuid-ossp";

create table tarefa (
  id UUID primary key default uuid_generate_v4(),
  nome varchar(255) not null,
  descricao varchar(255),
  propriedade varchar(255) not null,
  situacao varchar(255) not null,
  data_prevista_conclusao date,
  data_criacao timestamp(6) default CURRENT_TIMESTAMP
);