import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Tarefas } from '../entidade/tarefa';
import { TarefaResponse } from '../types/tarefa-response.type';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  private apiUrl = "http://localhost:8080/tarefa";

  constructor(private httpClient: HttpClient) {}

  obterTarefa(): Observable<Tarefas[]>{
    return this.httpClient.get<Tarefas[]>(this.apiUrl);
  }
  cadastrarTarefa(nome:string, descricao:string, propriedade:string, dataPrevistaConclusao:string){
    return this.httpClient.post<TarefaResponse>(this.apiUrl, {nome,descricao,propriedade,dataPrevistaConclusao}).pipe(
      tap( ( value)=>{
        sessionStorage.setItem("id",value.id),
        sessionStorage.setItem("nome",value.nome),
        sessionStorage.setItem("descricao",value.descricao),
        sessionStorage.setItem("propriedade",value.propriedade),
        sessionStorage.setItem("situacao",value.situacao),
        sessionStorage.setItem("dataPrevistaConclusao",value.dataPrevistaConclusao),
        sessionStorage.setItem("dataCriacao",value.dataCriacao)
      })
    )
  }
}