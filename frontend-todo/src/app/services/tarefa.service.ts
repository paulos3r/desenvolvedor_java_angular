import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tarefas } from '../entidade/tarefa';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  private apiUrl = "http://localhost:8080/tarefa";

  constructor(private httpClient: HttpClient) {}

  obterTarefa(): Observable<Tarefas[]>{
    return this.httpClient.get<Tarefas[]>(this.apiUrl);
  }

}