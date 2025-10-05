import { Component } from '@angular/core';
import { TarefaLayoutComponent } from '../../component/tarefa-layout/tarefa-layout.component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { PrimaryInputComponent } from '../../component/primary-input/primary-input.component';
import { Route, Router } from '@angular/router';
import { TarefaService } from '../../services/tarefa.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-tarefa',
  imports: [TarefaLayoutComponent,
    ReactiveFormsModule,
    PrimaryInputComponent
  ],
  providers: [
    TarefaService
  ],
  templateUrl: './tarefa.component.html',
  styleUrl: './tarefa.component.css',
  standalone:true
})
export class TarefaComponent {

  tarefaForm!: FormGroup;

  constructor(
    private router: Router,
    private tarefaService: TarefaService
  ){
    this.tarefaForm=new FormGroup({
      id: new FormControl(''),
      nome: new FormControl('',[Validators.required]),
      descricao: new FormControl(''),
      prioridade: new FormControl('',[Validators.required]),
      situacao: new FormControl('',[Validators.required]),
      dataPrevistaConclusao: new FormControl('',[Validators.required])
    })
  }

  submit(){

    this.tarefaService.cadastrarTarefa(
      this.tarefaForm.value.nome,
      this.tarefaForm.value.descricao,
      this.tarefaForm.value.propriedade,
      this.tarefaForm.value.situacao,
      this.tarefaForm.value.dataPrevistaConclusao
    ).subscribe({
      next: () => console.log("sucesso"),
      error: (err) => console.error("error",err)
    })

  }
  navigate(){
    console.log(this.tarefaForm.value)
  }

}
