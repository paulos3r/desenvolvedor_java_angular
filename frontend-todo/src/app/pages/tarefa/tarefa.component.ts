import { Component } from '@angular/core';
import { TarefaLayoutComponent } from '../../component/tarefa-layout/tarefa-layout.component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { PrimaryInputComponent } from '../../component/primary-input/primary-input.component';

@Component({
  selector: 'app-tarefa',
  imports: [TarefaLayoutComponent,
    ReactiveFormsModule,
    PrimaryInputComponent
  ],
  templateUrl: './tarefa.component.html',
  styleUrl: './tarefa.component.css',
  standalone:true
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
