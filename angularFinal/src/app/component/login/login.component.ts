import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

import { Compte } from 'src/app/model/compte';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login = '';
  password = '';
  showError = false;
  showMessage = false;

  constructor(
    private authSrv: AuthenticationService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.showMessage = false;
    this.activatedRoute.queryParams.subscribe((queryParams) => {
      console.log(queryParams);
      if (queryParams['inscription']) {
        this.showMessage = true;
      }
    });
  }

  check() {
    this.authSrv.authentication(this.login, this.password).subscribe({
      next: (compte: Compte) => {
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
