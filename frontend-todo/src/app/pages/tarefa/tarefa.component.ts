import { Component } from '@angular/core';
import { TarefaLayoutComponent } from '../../component/tarefa-layout/tarefa-layout.component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-tarefa',
  imports: [TarefaLayoutComponent,
    ReactiveFormsModule
  ],
  templateUrl: './tarefa.component.html',
  styleUrl: './tarefa.component.css'
})
export class TarefaComponent {

  tarefaForm!: FormGroup;

  constructor(){
    this.tarefaForm=new FormGroup({
      id: new FormControl(''),
      nome: new FormControl('',[Validators.required]),
      descricao: new FormControl(''),
      prioridade: new FormControl('',[Validators.required]),
      situacao: new FormControl('',[Validators.required]),
      dataPrevistaConclusao: new FormControl('',[Validators.required])
    })
  }

}
