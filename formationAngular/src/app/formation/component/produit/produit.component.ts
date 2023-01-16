import { Produit } from './../../model/produit';
import { Component } from '@angular/core';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent {
  infoProduit = '';
  produit: Produit = new Produit();
  produitAEnvoyer = new Produit();

  afficherMessage() {
    this.produitAEnvoyer = new Produit(this.produit.libelle, this.produit.prix);
    this.produit = new Produit();
  }
}
