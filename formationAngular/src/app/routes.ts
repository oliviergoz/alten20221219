import { PageNotFoundComponent } from './formation/component/page-not-found/page-not-found.component';
import { HomeComponent } from './formation/component/home/home.component';
import { ListProduitComponent } from './formation/component/produit/list-produit/list-produit.component';
import { Routes } from '@angular/router';
import { ParametreComponent } from './formation/component/parametre/parametre.component';

export const routes: Routes = [
  { path: 'produits', component: ListProduitComponent },
  { path: 'home', component: HomeComponent },
  { path: 'parametre', component: ParametreComponent },
  { path: 'parametre/:prenom', component: ParametreComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent },
];
