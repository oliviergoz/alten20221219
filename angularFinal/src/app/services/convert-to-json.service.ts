import { Compte } from './../model/compte';
import { Formation } from './../model/formation';
import { Formateur } from './../model/formateur';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ConvertToJsonService {
  constructor() {}

  public formateurToJson(formateur: Formateur): any {
    let obj = {
      prenom: formateur.prenom,
      nom: formateur.nom,
      email: formateur.email,
      interne: formateur.interne,
      cout: formateur.cout,
      dtNaiss: formateur.dtNaiss,
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

  public formationToJson(formation: Formation): any {
    let formationJson = {
      libelle: formation.libelle,
      description: formation.description,
      distanciel: formation.distanciel,
    };
    if (formation.referent) {
      Object.assign(formationJson, {
        referent: this.formateurToJson(formation.referent),
      });
    }
    if (formation.id) {
      Object.assign(formationJson, { id: formation.id });
    }
    return formationJson;
  }
}
