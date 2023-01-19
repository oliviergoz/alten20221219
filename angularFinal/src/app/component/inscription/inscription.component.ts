import { CompteService } from './../../services/compte.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  constructor(private compteSrv: CompteService) {}

  ngOnInit(): void {}

  save() {}
}
