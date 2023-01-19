import { Router } from '@angular/router';
import { CustomValidator } from './../../validators/custom-validator';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CompteService } from './../../services/compte.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form!: FormGroup;

  constructor(private compteSrv: CompteService, private router: Router) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      login: new FormControl(
        '',
        Validators.required,
        CustomValidator.checkLogin(this.compteSrv)
      ),
      passwordGroup: new FormGroup(
        {
          password: new FormControl('', [
            Validators.required,
            Validators.pattern(/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{4,20}$/),
          ]),
          confirm: new FormControl('', [
            Validators.required,
            Validators.pattern(/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{4,20}$/),
          ]),
        },
        CustomValidator.egaux
      ),
    });
  }

  save() {
    this.compteSrv
      .inscription({
        login: this.form.get('login')?.value,
        passwd: this.form.get('passwordGroup.password')?.value,
      })
      .subscribe(() => {
        this.router.navigateByUrl('/login?inscription=ok');
      });
  }
}
