import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { DemoComponent } from './formation/component/demo/demo.component';
import { FormsModule } from '@angular/forms';
import { ProduitComponent } from './formation/component/produit/produit.component';
import { InputComponent } from './formation/component/input/input.component';

import { OutputComponent } from './formation/component/output/output.component';
import { DisplayProduitComponent } from './formation/component/produit/display.produit/display.produit.component';
import { EditProduitComponent } from './formation/component/produit/edit-produit/edit-produit.component';
import { ElementSondageComponent } from './formation/component/sondage/element-sondage/element-sondage.component';
import { SondageComponent } from './formation/component/sondage/sondage/sondage.component';
import { DirectiveComponent } from './formation/component/directive/directive.component';
import { ListProduitComponent } from './formation/component/produit/list-produit/list-produit.component';
import { CouleurDirective } from './formation/directive/couleur.directive';
import { LigneProduitComponent } from './formation/component/produit/ligne-produit/ligne-produit.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './formation/component/home/home.component';
import { PageNotFoundComponent } from './formation/component/page-not-found/page-not-found.component';
import { routes } from './routes';
import { NavbarComponent } from './formation/component/navbar/navbar.component';
import { ParametreComponent } from './formation/component/parametre/parametre.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    ProduitComponent,
    InputComponent,
    DisplayProduitComponent,
    OutputComponent,
    EditProduitComponent,
    ElementSondageComponent,
    SondageComponent,
    DirectiveComponent,
    ListProduitComponent,
    CouleurDirective,
    LigneProduitComponent,
    HomeComponent,
    PageNotFoundComponent,
    NavbarComponent,
    ParametreComponent,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
