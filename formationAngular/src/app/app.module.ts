import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { DemoComponent } from './formation/component/demo/demo.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AppComponent, DemoComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
