import { ConvertToJsonService } from './convert-to-json.service';
import { Formateur } from './../model/formateur';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FormateurService {
  private url: string = 'http://localhost:8080/formation/api/formateur';

  constructor(
    private httpClient: HttpClient,
    private convert: ConvertToJsonService
  ) {}

  public getAll(): Observable<Formateur[]> {
    // let headers = new HttpHeaders({
    //   Authorization: 'Basic ' + window.btoa('toto:toto'),
    // });

    return this.httpClient.get<Formateur[]>(this.url);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public getById(id: number): Observable<Formateur> {
    return this.httpClient.get<Formateur>(`${this.url}/${id}`);
  }

  public create(formateur: Formateur): Observable<Formateur> {
    return this.httpClient.post<Formateur>(
      this.url,
      this.convert.formateurToJson(formateur)
    );
  }

  public update(formateur: Formateur): Observable<Formateur> {
    return this.httpClient.put<Formateur>(
      `${this.url}/${formateur.id}`,
      this.convert.formateurToJson(formateur)
    );
  }
}
