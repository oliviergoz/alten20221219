import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FormateurService {
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<any[]> {
    return this.httpClient.get<any[]>(
      'http://localhost:8080/formation/api/formateur'
    );
  }
}
