import { Produit } from './../../../model/produit';
import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-edit-produit',
  templateUrl: './edit-produit.component.html',
  styleUrls: ['./edit-produit.component.css'],
})
export class EditProduitComponent {
  produit: Produit = new Produit();

  @Output()
  produitPret: EventEmitter<Produit> = new EventEmitter();

  envoyerProduit() {
    this.produitPret.emit(this.produit);
    this.produit = new Produit();
  }
}
