import { Produit } from './../../../model/produit';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-ligne-produit,[ligneProduit]',
  templateUrl: './ligne-produit.component.html',
  styleUrls: ['./ligne-produit.component.css'],
})
export class LigneProduitComponent {
  @Input()
  produit!: Produit;
}
