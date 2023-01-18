import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Compte } from '../model/compte';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor(private httpClient: HttpClient) {}

  public authentication(login: string, password: string): Observable<any> {
    let headers = new HttpHeaders({
      Authorization: 'Basic ' + window.btoa(login + ':' + password),
    });
    return this.httpClient.get<any>(
      'http://localhost:8080/formation/api/auth',
      { headers: headers }
    );
  }

  public isAuthenticated(): boolean {
    return localStorage.getItem('tokenId') != null ? true : false;
  }

  public isInterne(): boolean {
    if (localStorage.getItem('compte') != null) {
      let compte: Compte = JSON.parse(localStorage.getItem('compte')!);
      return compte.role == 'ROLE_INTERNE';
    }
    return false;
  }
}
