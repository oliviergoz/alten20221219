import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { DemoComponent } from './formation/component/demo/demo.component';
import { FormsModule } from '@angular/forms';
import { ProduitComponent } from './formation/component/produit/produit.component';
import { InputComponent } from './formation/component/input/input.component';
import { DisplayProduitComponent } from './formation/component/produit/display.produit/display.produit.component';
import { OutputComponent } from './formation/component/output/output.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    ProduitComponent,
    InputComponent,
    DisplayProduitComponent,
    OutputComponent,
  ],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
