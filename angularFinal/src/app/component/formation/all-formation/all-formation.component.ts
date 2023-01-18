import { AuthenticationService } from 'src/app/services/authentication.service';
import { Observable } from 'rxjs';
import { Formation } from './../../../model/formation';
import { FormationService } from './../../../services/formation.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-formation',
  templateUrl: './all-formation.component.html',
  styleUrls: ['./all-formation.component.css'],
})
export class AllFormationComponent implements OnInit {
  // formations: Formation[] = [];

  // ngOnInit(): void {
  //   this.formationSrv.getAll().subscribe((formations: Formation[]) => {
  //     this.formations = formations;
  //   });
  // }

  observableFormations!: Observable<Formation[]>;

  constructor(
    private formationSrv: FormationService,
    private authSrv: AuthenticationService
  ) {}

  ngOnInit(): void {
    this.observableFormations = this.formationSrv.getAll();
  }

  delete(id: number) {}

  get interne() {
    return this.authSrv.isInterne();
  }
}
