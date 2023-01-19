import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-formulaire-template',
  templateUrl: './formulaire-template.component.html',
  styleUrls: ['./formulaire-template.component.css'],
})
export class FormulaireTemplateComponent {
  inputForm = '';

  submit(form: NgForm) {
    console.log(form);
    if (form.valid) {
      console.log(form.controls['inputForm'].value);
    }
  }
}
