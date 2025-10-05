import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-tarefa-layout',
  imports: [],
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

  submit(){
    this.onSubmit.emit();
  }
  navigate(){
    this.onNavigate.emit();
  }


}
