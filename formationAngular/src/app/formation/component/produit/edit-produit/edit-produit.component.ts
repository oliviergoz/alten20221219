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
  produitPret: EventEmitter<any> = new EventEmitter();
  //any=>{}
  envoyerProduit() {
    this.produitPret.emit({
      libelle: this.produit.libelle,
      prix: this.produit.prix,
    });
    this.produit = new Produit();
  }
}
