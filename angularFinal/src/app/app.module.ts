import { routes } from './routes';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { AllFormateurComponent } from './component/formateur/all-formateur/all-formateur.component';
import { FormateurComponent } from './component/formateur/formateur/formateur.component';
import { FormationComponent } from './component/formation/formation/formation.component';
import { AllFormationComponent } from './component/formation/all-formation/all-formation.component';
import { PathNotFoundComponent } from './component/path-not-found/path-not-found.component';
import { MenuComponent } from './component/menu/menu.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './component/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AllFormateurComponent,
    FormateurComponent,
    FormationComponent,
    AllFormationComponent,
    PathNotFoundComponent,
    MenuComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
