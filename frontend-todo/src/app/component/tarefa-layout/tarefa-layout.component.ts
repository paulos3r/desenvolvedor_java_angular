import { CommonModule } from '@angular/common';
import { Component, EventEmitter, inject, Input, OnInit, Output } from '@angular/core';
import { TarefaService } from '../../services/tarefa.service';
import { Observable } from 'rxjs';
import { TarefaResponse } from '../../types/tarefa-response.type';


@Component({
  selector: 'app-tarefa-layout',
  imports: [CommonModule],
  templateUrl: './tarefa-layout.component.html',
  styleUrl: './tarefa-layout.component.css',
  standalone:true
})
export class TarefaLayoutComponent {
  @Input() title: string="";
  @Input() textBtnPrimary: string=""
  @Input() textBtnSecundary: string=""

  @Output("submit") onSubmit = new EventEmitter();

  @Output("navigate") onNavigate = new EventEmitter();

  @Output("remove") onRemove = new EventEmitter();

  submit(){
    this.onSubmit.emit();
  }
  navigate(){
    this.onNavigate.emit();
  }
  remove(){
    this.onRemove.emit();
  }

  private tarefaService = inject(TarefaService);

  tarefas$:Observable<any[]> = this.tarefaService.obterTarefa();
}
