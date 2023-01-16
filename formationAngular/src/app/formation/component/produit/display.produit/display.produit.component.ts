import { Produit } from './../../../model/produit';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-displayProduit',
  templateUrl: './display.produit.component.html',
  styleUrls: ['./display.produit.component.css'],
})
export class DisplayProduitComponent {
  @Input()
  produit!: Produit;
}
