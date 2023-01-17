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
    return this.httpClient.post<Formateur>(
      this.url,
      this.formateurToJson(formateur)
    );
  }

  public formateurToJson(formateur: Formateur): any {
    let obj = {
      prenom: formateur.prenom,
      nom: formateur.nom,
      email: formateur.email,
      interne: formateur.interne,
      cout: formateur.cout,
    };
    if (formateur.adresse) {
      Object.assign(obj, {
        adresse: {
          numero: formateur.adresse.numero,
          rue: formateur.adresse.rue,
          codePostal: formateur.adresse.codePostal,
          ville: formateur.adresse.ville,
        },
      });
    }
    if (formateur.id) {
      Object.assign(obj, { id: formateur.id });
    }
    return obj;
  }

  public update(formateur: Formateur): Observable<Formateur> {
    return this.httpClient.put<Formateur>(
      `${this.url}/${formateur.id}`,
      this.formateurToJson(formateur)
    );
  }
}
