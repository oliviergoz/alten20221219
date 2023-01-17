import { Formateur } from './../model/formateur';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FormateurService {
  private url: string = 'http://localhost:8080/formation/api/formateur';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Formateur[]> {
    return this.httpClient.get<Formateur[]>(this.url);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public getById(id: number): Observable<Formateur> {
    return this.httpClient.get<Formateur>(`${this.url}/${id}`);
  }

  public create(formateur: Formateur): Observable<Formateur> {
    console.debug(formateur);
    return this.httpClient.post<Formateur>(this.url, formateur);
  }

  public update(formateur: Formateur): Observable<Formateur> {
    console.debug(formateur);
    return this.httpClient.put<Formateur>(
      `${this.url}/${formateur.id}`,
      formateur
    );
  }
}
