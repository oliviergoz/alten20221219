import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent implements OnInit {
  constructor(private authSrv: AuthenticationService, private router: Router) {}

  ngOnInit(): void {}

  get login(): string | undefined {
    if (this.authSrv.isAuthenticated()) {
      return JSON.parse(localStorage.getItem('compte')!).login;
    }
    return;
  }

  get logged(): boolean {
    return this.authSrv.isAuthenticated();
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/home');
  }
}
