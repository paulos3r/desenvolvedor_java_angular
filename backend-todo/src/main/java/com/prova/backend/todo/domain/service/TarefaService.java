package com.prova.backend.todo.domain.service;

import com.prova.backend.todo.domain.model.Propriedade;
import com.prova.backend.todo.domain.model.Tarefa;
import com.prova.backend.todo.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

  private final List<String> PROPRIEDADE = List.of("BAIXA","MEDIA","ALTA");

  private final TarefaRepository tarefaRepository;

  public TarefaService(TarefaRepository tarefaRepository) {
    this.tarefaRepository = tarefaRepository;
  }

  public List<Tarefa> findAllTarefa(){
    return this.tarefaRepository.findAll();
  }

  public Tarefa findTarefa(Long id){
    return this.tarefaRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Tarefa não foi encontrada"));
  }

  @Transactional
  public Tarefa createTarefa(String nome,String descricao,String propriedade,LocalDate dataPrevistaConclusao){

    if(!PROPRIEDADE.contains(propriedade.trim().toUpperCase())){
      throw new IllegalArgumentException("Propriedade não existe");
    }

    Propriedade isPropriedade = Propriedade.valueOf(propriedade);

    Tarefa tarefa = new Tarefa(nome, descricao, isPropriedade, dataPrevistaConclusao);

    tarefaRepository.save(tarefa);

    return tarefa;
  }

  @Transactional
  public Tarefa updateTarefa(Long id, String nome,String descricao,String propriedade,LocalDate dataPrevistaConclusao){
    Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Não foi encontrado nem uma tarefa com esse id"));

    Propriedade isPropriedade = Propriedade.valueOf(propriedade.trim().toUpperCase());

    tarefa.alterarNome(nome);
    tarefa.alterarDescricao(descricao);
    tarefa.alterarPropriedade(isPropriedade);
    tarefa.alterarDataPrevistaConclusao(dataPrevistaConclusao);

    tarefaRepository.save(tarefa);
    return tarefa;
  }

  @Transactional
  public void deleteTarefaById(Long id){
    Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Não foi encontrado nem uma tarefa com esse id"));

    tarefaRepository.delete(tarefa);
  }
}
