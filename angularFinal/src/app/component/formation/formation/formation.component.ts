import { Formateur } from './../../../model/formateur';
import { Observable } from 'rxjs';
import { FormateurService } from './../../../services/formateur.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormationService } from './../../../services/formation.service';
import { Formation } from './../../../model/formation';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  styleUrls: ['./formation.component.css'],
})
export class FormationComponent implements OnInit {
  formation: Formation = new Formation();
  obsFormateurs!: Observable<Formateur[]>;

  constructor(
    private formationSrv: FormationService,
    private formateurSrv: FormateurService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.obsFormateurs = this.formateurSrv.getAll();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.formationSrv
          .getById(params['id'])
          .subscribe((formation: Formation) => {
            this.formation = formation;
          });
      }
    });
  }

  save() {
    if (this.formation.id) {
      this.formationSrv.update(this.formation).subscribe((formateur) => {
        this.router.navigateByUrl('/formation');
      });
    } else {
      this.formationSrv.create(this.formation).subscribe((formateur) => {
        this.router.navigateByUrl('/formation');
      });
    }
  }

  compareFormateurById(formateur1: Formateur, formateur2: Formateur) {
    return formateur1 && formateur2 && formateur1.id == formateur2.id;
  }
}
