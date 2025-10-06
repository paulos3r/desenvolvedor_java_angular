package com.prova.backend.todo.controller;


import com.prova.backend.todo.domain.model.Tarefa;
import com.prova.backend.todo.domain.service.TarefaService;
import com.prova.backend.todo.dto.TarefaDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tarefa")
@CrossOrigin(origins = "*")
public class TarefaController {
  @Autowired
  private final TarefaService tarefaService;

  @Autowired
  public TarefaController(TarefaService tarefaService) {
    this.tarefaService = tarefaService;
  }

  @PostMapping
  public ResponseEntity<Object> postTarefa(@RequestBody @Valid TarefaDTO tarefaDTO){

    try {
      Tarefa tarefa = tarefaService.createTarefa(
              tarefaDTO.nome(),
              tarefaDTO.descricao(),
              tarefaDTO.propriedade(),
              tarefaDTO.dataPrevistaConclusao()
      );

      return ResponseEntity.status(HttpStatus.CREATED).body(
              new TarefaDTO(
                      tarefa.getId(),
                      tarefa.getNome(),
                      tarefa.getDescricao(),
                      tarefa.getPrioridade().toString(),
                      tarefa.getSituacao().toString(),
                      tarefa.getDataPrevistaConclusao(),
                      tarefa.getDataCriacao()
              )
      );

    }catch (EntityNotFoundException e){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }catch (IllegalArgumentException | NoSuchElementException | ConstraintViolationException e){
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }catch (Exception e ){
      e.printStackTrace();
      System.out.println(e.getMessage());

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping
  public ResponseEntity<Page<TarefaDTO>> getAllTarefa(Pageable pageable){

    try {
      Page<Tarefa> tarefa = tarefaService.findAllTarefa(pageable);

      Page<TarefaDTO> tarefasDto =  tarefa
              .map(tarefa1 -> new TarefaDTO(
                      tarefa1.getId(),
                      tarefa1.getNome(),
                      tarefa1.getDescricao(),
                      tarefa1.getPrioridade().toString(),
                      tarefa1.getSituacao().toString(),
                      tarefa1.getDataPrevistaConclusao(),
                      tarefa1.getDataCriacao()
              ));
      return ResponseEntity.status(HttpStatus.OK).body(tarefasDto);

    }catch (EntityNotFoundException e ){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getTarefaById(@PathVariable Long id){
    try {
      Tarefa tarefa = tarefaService.findTarefa(id);

      return ResponseEntity.status(HttpStatus.OK).body(
              new TarefaDTO(
                tarefa.getId(),
                tarefa.getNome(),
                tarefa.getDescricao(),
                tarefa.getPrioridade().toString(),
                tarefa.getSituacao().toString(),
                tarefa.getDataPrevistaConclusao(),
                tarefa.getDataCriacao()
              )
      );

    }catch (EntityNotFoundException e ){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> putTarefaById(@PathVariable Long id, @RequestBody @Valid TarefaDTO tarefaDTO){
    try {
      Tarefa tarefa =  tarefaService.updateTarefa(
              id,
              tarefaDTO.nome(),
              tarefaDTO.descricao(),
              tarefaDTO.propriedade(),
              tarefaDTO.dataPrevistaConclusao()
      );

      return ResponseEntity.status( HttpStatus.OK ).body(
              new TarefaDTO(
                      tarefa.getId(),
                      tarefa.getNome(),
                      tarefa.getDescricao(),
                      tarefa.getPrioridade().toString(),
                      tarefa.getSituacao().toString(),
                      tarefa.getDataPrevistaConclusao(),
                      tarefa.getDataCriacao()
              )
      );

    }catch (EntityNotFoundException e){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }catch (IllegalArgumentException | NoSuchElementException e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }catch (Exception e){
      e.printStackTrace();
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> deleteTarefaById(@PathVariable Long id){
    try{
      tarefaService.deleteTarefaById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }catch ( EntityNotFoundException e ){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }catch (IllegalArgumentException |
            NoSuchElementException |
            DataIntegrityViolationException |
            ConstraintViolationException e ){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }catch (Exception e){
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @PatchMapping("/{id}/concluir")
  public ResponseEntity<Object> patchConcluirTarefa(@PathVariable Long id){

    Tarefa tarefa = tarefaService.completarTarefa(id);

    return ResponseEntity.status(HttpStatus.OK).body(
            new TarefaDTO(
                    tarefa.getId(),
                    tarefa.getNome(),
                    tarefa.getDescricao(),
                    tarefa.getPrioridade().toString(),
                    tarefa.getSituacao().toString(),
                    tarefa.getDataPrevistaConclusao(),
                    tarefa.getDataCriacao()
            )
    );

  }

  @PatchMapping("/{id}/pendente")
  public ResponseEntity<Object> patchPendenteTarefa(@PathVariable Long id){
    Tarefa tarefa = tarefaService.tarefaPendente(id);

    return ResponseEntity.status(HttpStatus.OK).body(
            new TarefaDTO(
                    tarefa.getId(),
                    tarefa.getNome(),
                    tarefa.getDescricao(),
                    tarefa.getPrioridade().toString(),
                    tarefa.getSituacao().toString(),
                    tarefa.getDataPrevistaConclusao(),
                    tarefa.getDataCriacao()
            )
    );
  }
}