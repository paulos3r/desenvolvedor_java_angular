package com.prova.backend.todo.domain.service;

import com.prova.backend.todo.domain.model.Prioridade;
import com.prova.backend.todo.domain.model.Situacao;
import com.prova.backend.todo.domain.model.Tarefa;
import com.prova.backend.todo.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {

  private final List<String> PRIORIDADE = List.of("BAIXA","MEDIA","ALTA");

  private final TarefaRepository tarefaRepository;

  public TarefaService(TarefaRepository tarefaRepository) {
    this.tarefaRepository = tarefaRepository;
  }

  public Page< Tarefa > findAllTarefa(Pageable pageable){
    return this.tarefaRepository.findAll(pageable);
  }

  public Tarefa findTarefa(Long id){
    return this.tarefaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Tarefa não foi encontrada"));
  }

  @Transactional
  public Tarefa createTarefa(String nome,String descricao,String prioridade,LocalDate dataPrevistaConclusao){

    if(!PRIORIDADE.contains(prioridade.trim().toUpperCase())){
      throw new IllegalArgumentException("Propriedade não existe");
    }

    Prioridade isPropriedade = Prioridade.valueOf(prioridade);

    Tarefa tarefa = new Tarefa(nome, descricao, isPropriedade, dataPrevistaConclusao);

    tarefaRepository.save(tarefa);

    return tarefa;
  }

  @Transactional
  public Tarefa updateTarefa(Long id, String nome,String descricao,String propriedade,LocalDate dataPrevistaConclusao){
    Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Não foi encontrado nem uma tarefa com esse id"));

    Prioridade isPrioridade = Prioridade.valueOf(propriedade.trim().toUpperCase());

    tarefa.alterarNome(nome);
    tarefa.alterarDescricao(descricao);
    tarefa.alterarPrioridade(isPrioridade);
    tarefa.alterarDataPrevistaConclusao(dataPrevistaConclusao);

    tarefaRepository.save(tarefa);
    return tarefa;
  }

  @Transactional
  public void deleteTarefaById(Long id){
    Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Não foi encontrado nem uma tarefa com esse id"));

    tarefaRepository.delete(tarefa);
  }

  @Transactional
  public Tarefa completarTarefa(Long id){
    Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Cadastro não encontrado"));

    if(tarefa.getSituacao()== Situacao.ABERTA || tarefa.getSituacao()==Situacao.PENDENTE){
      tarefa.alterarSituacao(Situacao.CONCLUIDA);
      return tarefaRepository.save(tarefa);
    }else
      throw new IllegalArgumentException("Não é possível concluir uma tarefa neste status.");
  }

  @Transactional
  public Tarefa tarefaPendente(Long id){
    Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Cadastro não encontrado"));

    if(tarefa.getSituacao()== Situacao.ABERTA || tarefa.getSituacao()==Situacao.CONCLUIDA){
      tarefa.alterarSituacao(Situacao.PENDENTE);
      return tarefaRepository.save(tarefa);
    }else
      throw new IllegalArgumentException("Não é possível concluir uma tarefa neste status.");
  }

}
