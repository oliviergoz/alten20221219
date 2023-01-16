import { Personne } from './../../model/personne';
import { Component } from '@angular/core';

@Component({
  selector: 'app-directive',
  templateUrl: './directive.component.html',
  styleUrls: ['./directive.component.css'],
})
export class DirectiveComponent {
  tab = ['olivier', 'arthur', 'antoine'];

  personnes: Personne[] = [
    new Personne('olivier', 'gozlan'),
    new Personne('ambre', 'michel'),
    new Personne('antoine', 'rombaut'),
  ];
}
