import { Component } from '@angular/core';
import { Produit } from 'src/app/formation/model/produit';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
})
export class ListProduitComponent {
  produits: Produit[] = [new Produit('aaa', 11), new Produit('vvv', 1111)];

  ajouterProduit(produit: Produit) {
    this.produits.push(produit);
  }
}
