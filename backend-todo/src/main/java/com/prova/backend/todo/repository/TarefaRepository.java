package com.prova.backend.todo.repository;

import com.prova.backend.todo.domain.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}