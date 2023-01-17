import { FormationComponent } from './component/formation/formation/formation.component';
import { FormateurComponent } from './component/formateur/formateur/formateur.component';
import { AllFormateurComponent } from './component/formateur/all-formateur/all-formateur.component';
import { AllFormationComponent } from './component/formation/all-formation/all-formation.component';
import { Routes } from '@angular/router';
import { PathNotFoundComponent } from './component/path-not-found/path-not-found.component';
import { HomeComponent } from './component/home/home.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'formation', component: AllFormationComponent },
  { path: 'formateur', component: AllFormateurComponent },
  { path: 'formateur/:id', component: FormateurComponent },
  { path: 'formation/:id', component: FormationComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', component: PathNotFoundComponent },
];
