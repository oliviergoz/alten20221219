import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Compte } from '../model/compte';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  constructor(private httpClient: HttpClient) {}

  //compte est un objet json du model {login,passwd}
  public inscription(compte: any): Observable<Compte> {
    return this.httpClient.post<Compte>(
      'http://localhost:8080/formation/api/inscription',
      compte
    );
  }

  public checkLoginExist(login: string): Observable<boolean> {
    if (login) {
      return this.httpClient.get<boolean>(
        `http://localhost:8080/formation/api/compte/checklogin/${login}`
      );
    }
    return new Observable((observer) => {
      observer.next(false);
    });
  }
}
