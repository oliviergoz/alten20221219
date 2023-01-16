import { Personne } from './../../model/personne';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css'],
})
export class InputComponent implements OnInit {
  @Input()
  information = '';
  @Input('info2')
  autreInfo = '';

  @Input()
  personne: Personne = new Personne();

  constructor() {
    console.log(this.personne);
  }
  ngOnInit(): void {
    console.log(this.personne);
  }
}
