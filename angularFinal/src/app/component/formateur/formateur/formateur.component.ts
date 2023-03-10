import { Adresse } from './../../../model/adresse';
import { FormateurService } from './../../../services/formateur.service';
import { Formateur } from './../../../model/formateur';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-formateur',
  templateUrl: './formateur.component.html',
  styleUrls: ['./formateur.component.css'],
})
export class FormateurComponent implements OnInit {
  formateur: Formateur = new Formateur();
  adresse: Adresse = new Adresse();

  constructor(
    private formateurService: FormateurService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.formateurService.getById(params['id']).subscribe((formateur) => {
          this.formateur = formateur;
          if (formateur.adresse) {
            this.adresse = formateur.adresse;
          }
        });
      }
    });
  }

  save() {
    this.formateur.adresse = this.adresse;
    if (this.formateur.id) {
      //update
      this.formateurService.update(this.formateur).subscribe((formateur) => {
        this.goAllFormateur();
      });
    } else {
      //create
      this.formateurService.create(this.formateur).subscribe((formateur) => {
        this.goAllFormateur();
      });
    }
  }

  goAllFormateur() {
    this.router.navigateByUrl('/formateur');
  }
}
