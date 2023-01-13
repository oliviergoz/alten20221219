export class Personne {
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  //attributs
  //visibilite nomAttribut:type(=valeur d'initialisation)
  // private prenom!: string;
  // private nom!: string;

  // constructor(prenom: string, nom: string) {
  //   this.prenom = prenom;
  //   this.nom = nom;
  // }

  private _prenom?: string | undefined;

  public get prenom(): string | undefined {
    return this._prenom;
  }
  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  constructor(prenom?: string, private _nom?: string) {
    this._prenom = prenom;
  }

  //methodes
  //visibilite nomMethode(parametre:typeParametre,...):typeRetour{}
  //si pas de retour void ou rien
}
