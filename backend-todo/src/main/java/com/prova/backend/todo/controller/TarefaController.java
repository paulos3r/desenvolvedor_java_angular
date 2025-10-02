package com.prova.backend.todo.controller;


import com.prova.backend.todo.domain.model.Tarefa;
import com.prova.backend.todo.domain.service.TarefaService;
import com.prova.backend.todo.dto.TarefaDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
  @Autowired
  private final TarefaService tarefaService;

  @Autowired
  public TarefaController(TarefaService tarefaService) {
    this.tarefaService = tarefaService;
  }

  @PostMapping
  public ResponseEntity<Object> postTarefa(@RequestBody TarefaDTO tarefaDTO){

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
                      tarefa.getPropriedade().toString(),
                      tarefa.getSituacao().toString(),
                      tarefa.getDataPrevistaConclusao(),
                      tarefa.getDataCriacao()
              )
      );

    }catch (EntityNotFoundException e){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }catch (IllegalArgumentException | NoSuchElementException e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }catch (Exception e ){
      e.printStackTrace();
      System.out.println(e.getMessage());

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping
  public ResponseEntity<Object> getAllTarefa(@RequestBody TarefaDTO tarefaDTO){

    try {
      List<Tarefa> tarefa = tarefaService.findAllTarefa();

      List<TarefaDTO> tarefasDto =  tarefa.stream()
              .map(tarefa1 -> new TarefaDTO(
                      tarefa1.getId(),
                      tarefa1.getNome(),
                      tarefa1.getDescricao(),
                      tarefa1.getPropriedade().toString(),
                      tarefa1.getSituacao().toString(),
                      tarefa1.getDataPrevistaConclusao(),
                      tarefa1.getDataCriacao()
              ))
              .toList();
      return ResponseEntity.status(HttpStatus.OK).body(tarefasDto);

    }catch (EntityNotFoundException e ){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @GetMapping("/id")
  public ResponseEntity<Object> getTarefaById(@PathVariable Long id){
    try {
      Tarefa tarefa = tarefaService.findTarefa(id);

      return ResponseEntity.status(HttpStatus.OK).body(
              new TarefaDTO(
                tarefa.getId(),
                tarefa.getNome(),
                tarefa.getDescricao(),
                tarefa.getPropriedade().toString(),
                tarefa.getSituacao().toString(),
                tarefa.getDataPrevistaConclusao(),
                tarefa.getDataCriacao()
              )
      );

    }catch (EntityNotFoundException e ){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PutMapping("/id")
  public ResponseEntity<Object> putTarefaById(@PathVariable Long id,  @RequestBody TarefaDTO tarefaDTO){
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
                      tarefa.getPropriedade().toString(),
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

  @DeleteMapping("/id")
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
}