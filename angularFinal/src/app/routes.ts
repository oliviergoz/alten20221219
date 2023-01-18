import { InterneGuardService } from './services/guards/interne-guard.service';
import { AuthenticatedGuardService } from './services/guards/authenticated-guard.service';
import { LoginComponent } from './component/login/login.component';
import { FormationComponent } from './component/formation/formation/formation.component';
import { FormateurComponent } from './component/formateur/formateur/formateur.component';
import { AllFormateurComponent } from './component/formateur/all-formateur/all-formateur.component';
import { AllFormationComponent } from './component/formation/all-formation/all-formation.component';
import { Routes } from '@angular/router';
import { PathNotFoundComponent } from './component/path-not-found/path-not-found.component';
import { HomeComponent } from './component/home/home.component';
import { AnonymousGuardService } from './services/guards/anonymous-guard.service';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'formation',
    component: AllFormationComponent,
    canActivate: [AuthenticatedGuardService],
  },
  {
    path: 'formateur',
    component: AllFormateurComponent,
    canActivate: [AuthenticatedGuardService],
  },
  {
    path: 'formateur/edit/:id',
    component: FormateurComponent,
    canActivate: [InterneGuardService],
  },
  {
    path: 'formateur/add',
    component: FormateurComponent,
    canActivate: [InterneGuardService],
  },
  {
    path: 'formation/edit/:id',
    component: FormationComponent,
    canActivate: [InterneGuardService],
  },
  {
    path: 'formation/add',
    component: FormationComponent,
    canActivate: [InterneGuardService],
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [AnonymousGuardService],
  },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', component: PathNotFoundComponent },
];
