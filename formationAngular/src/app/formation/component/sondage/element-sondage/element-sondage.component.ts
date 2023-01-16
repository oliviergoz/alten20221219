import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-equipe',
  templateUrl: './element-sondage.component.html',
  styleUrls: ['./element-sondage.component.css'],
})
export class ElementSondageComponent {
  @Input()
  equipe = '';
  vote = 0;
  @Output()
  voteRecu: EventEmitter<any> = new EventEmitter();

  voter() {
    this.vote++;
    this.voteRecu.emit({ equipe: this.equipe, vote: this.vote });
  }
}
