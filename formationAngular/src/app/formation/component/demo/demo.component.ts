import { Personne } from './../../model/personne';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css'],
})
export class DemoComponent {
  //toutes les donnees du component =>model
  personne: Personne = new Personne('olivier', 'gozlan');

  hello() {
    return 'Hello ';
  }
}
