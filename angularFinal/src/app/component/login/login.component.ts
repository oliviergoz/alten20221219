import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { AuthenticationService } from 'src/app/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  login = '';
  password = '';
  showError = false;

  constructor(private authSrv: AuthenticationService, private router: Router) {}

  check() {
    this.authSrv.authentication(this.login, this.password).subscribe({
      next: (compte) => {
        this.showError = false;
        localStorage.setItem(
          'tokenId',
          'Basic ' + window.btoa(this.login + ':' + this.password)
        );
        localStorage.setItem('compte', JSON.stringify(compte));
        this.router.navigateByUrl('/home');
      },
      error: () => {
        this.showError = true;
      },
    });
  }
}
