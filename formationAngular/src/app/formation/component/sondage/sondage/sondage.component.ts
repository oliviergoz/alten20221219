import { Component } from '@angular/core';

@Component({
  selector: 'app-sondage',
  templateUrl: './sondage.component.html',
  styleUrls: ['./sondage.component.css'],
})
export class SondageComponent {
  equipeEnTete = '';
  vote = 0;

  traitementVoteRecu(obj: any) {
    if (this.vote < obj.vote) {
      this.vote = obj.vote;
      this.equipeEnTete = obj.equipe;
    }
  }
}
