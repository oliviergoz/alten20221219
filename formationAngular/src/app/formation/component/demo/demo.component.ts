import { Image } from '../../model/image';

import { Component, OnInit } from '@angular/core';
import { Personne } from '../../model/personne';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css'],
})
export class DemoComponent {
  //toutes les donnees du component =>model
  personne: Personne = new Personne('olivier', 'gozlan');
  personneEnJson: Personne = { prenom: 'toto', nom: 'tutu' };
  image = 'maison.jpeg';
  objectImage: Image = new Image('assets/maison2.jpeg');

  hello() {
    return 'Hello ';
  }

  logHello(param: string) {
    console.log(param);
  }

  traitementEvenement(param: string) {
    console.log(param);
  }
}
