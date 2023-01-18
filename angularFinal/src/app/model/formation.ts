import { Formateur } from './formateur';

export class Formation {
  public get referent(): Formateur | undefined {
    return this._referent;
  }
  public set referent(value: Formateur | undefined) {
    this._referent = value;
  }
  public get distanciel(): boolean | undefined {
    return this._distanciel;
  }
  public set distanciel(value: boolean | undefined) {
    this._distanciel = value;
  }
  public get description(): string | undefined {
    return this._description;
  }
  public set description(value: string | undefined) {
    this._description = value;
  }
  public get libelle(): string | undefined {
    return this._libelle;
  }
  public set libelle(value: string | undefined) {
    this._libelle = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _libelle?: string,
    private _description?: string,
    private _distanciel?: boolean,
    private _referent?: Formateur
  ) {}
}
