import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { TarefaResponse } from '../types/tarefa-response.type';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  private apiUrl = "http://localhost:8080/tarefa";

  constructor(private httpClient: HttpClient) {}

  obterTarefa(): Observable<TarefaResponse[]>{
    return this.httpClient.get<TarefaResponse[]>(this.apiUrl);
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
  
  atualizarTarefa(id:string, t:Partial<TarefaResponse>){
    return this.httpClient.put(`${this.apiUrl}/${id}`,t);
  }

  excluirTarefa(id:string){
    return this.httpClient.delete(`${this.apiUrl}/${id}`)
  }
}