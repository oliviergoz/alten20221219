import { AuthenticationInterceptor } from './interceptors/authentication.interceptor';
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
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './component/login/login.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { FormulaireTemplateComponent } from './component/formulaire/formulaire-template/formulaire-template.component';
import { FormulaireCodeComponent } from './component/formulaire/formulaire-code/formulaire-code.component';

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
    InscriptionComponent,
    FormulaireTemplateComponent,
    FormulaireCodeComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthenticationInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
