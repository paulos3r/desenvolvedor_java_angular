import { Component, Input } from '@angular/core';
import { ɵEmptyOutletComponent } from "../../../../node_modules/@angular/router/router_module.d-Bx9ArA6K";

@Component({
  selector: 'app-tarefa-layout',
  imports: [ɵEmptyOutletComponent],
  templateUrl: './tarefa-layout.component.html',
  styleUrl: './tarefa-layout.component.css'
})
export class TarefaLayoutComponent {
  @Input() title: string="";
  @Input() textBtnPrimary: string=""
  @Input() textBtnSecundary: string=""
}
