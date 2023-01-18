import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

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
}
