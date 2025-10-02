package com.prova.backend.todo.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name= "tarefa")
@Table(name="tarefa")
public class Tarefa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String descricao;
  @Enumerated(EnumType.STRING)
  private Prioridade prioridade;
  @Enumerated(EnumType.STRING)
  private Situacao situacao;
  @Column(name = "data_prevista_conclusao")
  private LocalDate dataPrevistaConclusao;
  @Column(name = "data_criacao")
  private LocalDateTime dataCriacao;

  public Tarefa() {
  }

  /**
   *
   * @param nome
   * @param descricao
   * @param propriedade
   * @param dataPrevistaConclusao
   */
  public Tarefa(String nome, String descricao, Prioridade propriedade, LocalDate dataPrevistaConclusao) {
    if (nome==null || nome.isEmpty()){
      throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
    }
    if(dataPrevistaConclusao.isBefore(LocalDate.now())){
      throw new IllegalArgumentException("Date – Obrigatório, não pode ser anterior à data atual");
    }

    this.nome = nome;
    this.descricao = descricao;
    this.prioridade = propriedade;
    this.situacao = Situacao.ABERTA;
    this.dataPrevistaConclusao = dataPrevistaConclusao;
    this.dataCriacao = LocalDateTime.now();
  }

  public void alterarNome(String nome){
    if(nome==null || nome.isEmpty()){
      throw new IllegalArgumentException("Nome não pode ser vazio");
    }
    this.nome=nome;
  }

  public void alterarDescricao(String descricao){
    this.descricao=descricao;
  }

  public void alterarPrioridade(Prioridade prioridade) {
    if (prioridade==null){
      throw new IllegalArgumentException("Propiedade não pode ser nulo");
    }
    this.prioridade =prioridade;
  }

  public void alterarDataPrevistaConclusao(LocalDate dataPrevistaConclusao){

    if(dataPrevistaConclusao.isBefore(LocalDate.now())){
      throw new IllegalArgumentException("Date não pode ser anterior à data atual");
    }

    this.dataPrevistaConclusao=dataPrevistaConclusao;
  }

  public void alterarSituacao(Situacao situacao) {
    if (situacao==null){
      throw new IllegalArgumentException("Situação não pode ser nulo");
    }
    this.situacao=situacao;
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

  public Prioridade getPrioridade() {
    return prioridade;
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
    return Objects.equals(id, tarefa.id) && Objects.equals(nome, tarefa.nome) && Objects.equals(descricao, tarefa.descricao) && prioridade == tarefa.prioridade && situacao == tarefa.situacao && Objects.equals(dataPrevistaConclusao, tarefa.dataPrevistaConclusao) && Objects.equals(dataCriacao, tarefa.dataCriacao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, descricao, prioridade, situacao, dataPrevistaConclusao, dataCriacao);
  }

  @Override
  public String toString() {
    return "Tarefa{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", descricao='" + descricao + '\'' +
            ", propriedade=" + prioridade +
            ", situacao=" + situacao +
            ", dataPrevistaConclusao=" + dataPrevistaConclusao +
            ", dataCriacao=" + dataCriacao +
            '}';
  }
}
