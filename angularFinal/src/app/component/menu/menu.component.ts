import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/authentication.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent implements OnInit {
  constructor(private authSrv: AuthenticationService) {}

  ngOnInit(): void {}

  get login(): string | undefined {
    if (this.authSrv.isAuthenticated()) {
      console.log(localStorage.getItem('compte'));
      return JSON.parse(localStorage.getItem('compte')!).login;
    }
    return;
  }

  get logged(): boolean {
    return this.authSrv.isAuthenticated();
  }

  logout() {
    localStorage.clear();
  }
}
