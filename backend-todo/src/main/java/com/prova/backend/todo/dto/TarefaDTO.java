package com.prova.backend.todo.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TarefaDTO(
  Long id,
  @NotBlank(message = "Nome não pode ser vazio ou nulo.")
  String nome,
  String descricao,
  @NotBlank(message = "propiedade não pode ser vazio ou nulo.")
  String propriedade,
  String situacao,
  @FutureOrPresent(message = "A data de previsão de conclusão não pode ser uma data no passado")
  LocalDate dataPrevistaConclusao,
  LocalDateTime dataCriacao
) {
}
