import { CompteService } from './../../../services/compte.service';
import { CustomValidator } from './../../../validators/custom-validator';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulaire-code',
  templateUrl: './formulaire-code.component.html',
  styleUrls: ['./formulaire-code.component.css'],
})
export class FormulaireCodeComponent implements OnInit {
  form!: FormGroup;

  constructor(private compteSrv: CompteService) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      login: new FormControl(
        '',
        undefined,
        CustomValidator.checkLogin(this.compteSrv)
      ),
      prenom: new FormControl('', Validators.required),
      nom: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(20),
        CustomValidator.pasChaineToto,
        CustomValidator.pasChaine('tutu'),
      ]),
      group: new FormGroup(
        {
          control1: new FormControl(),
          control2: new FormControl(),
        },
        CustomValidator.pasEgaux
      ),
    });
  }

  submit() {
    console.log(this.form);
  }
}
