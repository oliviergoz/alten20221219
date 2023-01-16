import { Produit } from './../../model/produit';
import { Component } from '@angular/core';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent {
  produitAEnvoyer = new Produit();

  recuperationProduit(produitRecu: Produit) {
    this.produitAEnvoyer = produitRecu;
  }
}
