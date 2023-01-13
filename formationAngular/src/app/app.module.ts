import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { DemoComponent } from './formation/component/demo/demo.component';
import { FormsModule } from '@angular/forms';
import { ProduitComponent } from './formation/component/produit/produit.component';

@NgModule({
  declarations: [AppComponent, DemoComponent, ProduitComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
