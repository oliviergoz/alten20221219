import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.css'],
})
export class OutputComponent {
  informationAFaireSortir = '';

  @Output()
  informationPrete: EventEmitter<string> = new EventEmitter();

  declenchementEvenement() {
    this.informationPrete.emit(this.informationAFaireSortir);
  }
}
