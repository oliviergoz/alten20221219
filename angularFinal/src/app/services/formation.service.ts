import { ConvertToJsonService } from './convert-to-json.service';
import { Formation } from './../model/formation';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class FormationService {
  private url: string = 'http://localhost:8080/formation/api/formation';

  constructor(
    private httpClient: HttpClient,
    private convert: ConvertToJsonService
  ) {}

  public getAll(): Observable<Formation[]> {
    return this.httpClient.get<Formation[]>(this.url);
  }

  public getById(id: number): Observable<Formation> {
    return this.httpClient.get<Formation>(`${this.url}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public update(formation: Formation): Observable<Formation> {
    return this.httpClient.put<Formation>(
      `${this.url}/${formation.id}`,
      this.convert.formationToJson(formation)
    );
  }

  public create(formation: Formation): Observable<Formation> {
    return this.httpClient.post<Formation>(
      this.url,
      this.convert.formationToJson(formation)
    );
  }
}
