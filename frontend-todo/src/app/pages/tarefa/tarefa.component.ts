import { Component } from '@angular/core';
import { TarefaLayoutComponent } from '../../component/tarefa-layout/tarefa-layout.component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { PrimaryInputComponent } from '../../component/primary-input/primary-input.component';
import { Route, Router } from '@angular/router';
import { TarefaService } from '../../services/tarefa.service';
import { CommonModule } from '@angular/common';
import { TarefaResponse } from '../../types/tarefa-response.type';

@Component({
  selector: 'app-tarefa',
  standalone:true,
  imports: [TarefaLayoutComponent,
    ReactiveFormsModule,
    PrimaryInputComponent,
    CommonModule
  ],
  providers: [
    TarefaService
  ],
  templateUrl: './tarefa.component.html',
  styleUrl: './tarefa.component.css'
  
})
export class TarefaComponent{

  tarefaForm!: FormGroup;

  constructor(
    private router: Router,
    private tarefaService: TarefaService
  ){
    this.tarefaForm=new FormGroup({
      id: new FormControl(''),
      nome: new FormControl('',[Validators.required]),
      descricao: new FormControl(''),
      propriedade: new FormControl('',[Validators.required]),
      situacao: new FormControl('',[Validators.required]),
      dataPrevistaConclusao: new FormControl('',[Validators.required])
    });

    this.tarefaForm.valueChanges.subscribe(v=>console.log('form.valueChanges',v));
  }

  submit(){

    console.log(this.tarefaForm.value.propriedade)

    this.tarefaService.cadastrarTarefa(
      this.tarefaForm.value.nome,
      this.tarefaForm.value.descricao,
      this.tarefaForm.value.propriedade,
      this.tarefaForm.value.dataPrevistaConclusao
    ).subscribe({
      next: () => console.log("sucesso"),
      error: (err) => console.error("error",err)
    })

  }

  navigate(){
    console.log(this.tarefaForm.value)
  }

  remove(){
    this.tarefaService.excluirTarefa(this.tarefaForm.value.id);
  }

  tarefas:TarefaResponse[]=[];

  buscarTarefas(){
    this.tarefaService.obterTarefa().subscribe({
      next:( data) =>{
        console.log(data);
        this.tarefas=data;
      },
      error: (err)=> console.error("errro ao buscar tarefa:", err)
    });
  }

  ngOnInit(): void {
    this.buscarTarefas();
  }
}
