create table if not exists tarefa (
  id BIGSERIAL primary key,
  nome varchar(255) not null,
  descricao varchar(255),
  prioridade varchar(255) not null,
  situacao varchar(255) not null,
  data_prevista_conclusao date,
  data_criacao timestamp(6) default CURRENT_TIMESTAMP
);