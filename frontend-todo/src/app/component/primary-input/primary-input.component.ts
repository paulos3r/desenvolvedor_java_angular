import { Component, Input } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

type InputTypes = "text";

@Component({
  selector: 'app-primary-input',
  standalone:true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './primary-input.component.html',
  styleUrl: './primary-input.component.css'
})
export class PrimaryInputComponent {

  @Input() type: InputTypes = "text";
  @Input() formName: string ="";
  @Input() placeholder: string="";
  @Input() label: string="";
  
}
