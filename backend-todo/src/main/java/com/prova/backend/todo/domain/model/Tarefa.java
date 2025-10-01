package com.prova.backend.todo.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Tarefa {

  private Long id;
  private String nome;
  private String descricao;
  private Propriedade propriedade;
  private Situacao situacao;
  private LocalDate dataPrevistaConclusao;
  private LocalDateTime dataCriacao;

  public Tarefa() {
  }

  /**
   * Criação de um novo to-do
   * @param nome
   * @param descricao
   * @param propriedade
   * @param situacao
   * @param dataPrevistaConclusao
   */
  public Tarefa(String nome, String descricao, Propriedade propriedade, Situacao situacao, LocalDate dataPrevistaConclusao) {
    if (nome==null || nome.isEmpty()){
      throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
    }
    if(dataPrevistaConclusao.isAfter(LocalDate.now())){
      throw new IllegalArgumentException("Date – Obrigatório, não pode ser anterior à data atual");
    }

    this.nome = nome;
    this.descricao = descricao;
    this.propriedade = propriedade;
    this.situacao = Situacao.ABERTA;
    this.dataPrevistaConclusao = dataPrevistaConclusao;
    this.dataCriacao = LocalDateTime.now();
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public Propriedade getPropriedade() {
    return propriedade;
  }

  public Situacao getSituacao() {
    return situacao;
  }

  public LocalDate getDataPrevistaConclusao() {
    return dataPrevistaConclusao;
  }

  public LocalDateTime getDataCriacao() {
    return dataCriacao;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Tarefa tarefa)) return false;
    return Objects.equals(id, tarefa.id) && Objects.equals(nome, tarefa.nome) && Objects.equals(descricao, tarefa.descricao) && propriedade == tarefa.propriedade && situacao == tarefa.situacao && Objects.equals(dataPrevistaConclusao, tarefa.dataPrevistaConclusao) && Objects.equals(dataCriacao, tarefa.dataCriacao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, descricao, propriedade, situacao, dataPrevistaConclusao, dataCriacao);
  }

  @Override
  public String toString() {
    return "Tarefa{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", descricao='" + descricao + '\'' +
            ", propriedade=" + propriedade +
            ", situacao=" + situacao +
            ", dataPrevistaConclusao=" + dataPrevistaConclusao +
            ", dataCriacao=" + dataCriacao +
            '}';
  }
}
