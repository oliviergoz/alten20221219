import { Adresse } from './adresse';
export class Formateur {
  public get cout(): number | undefined {
    return this._cout;
  }
  public set cout(value: number | undefined) {
    this._cout = value;
  }
  public get interne(): boolean | undefined {
    return this._interne;
  }
  public set interne(value: boolean | undefined) {
    this._interne = value;
  }
  public get adresse(): Adresse | undefined {
    return this._adresse;
  }
  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }
  public get dtNaiss(): Date | undefined {
    return this._dtNaiss;
  }
  public set dtNaiss(value: Date | undefined) {
    this._dtNaiss = value;
  }
  public get email(): string | undefined {
    return this._email;
  }
  public set email(value: string | undefined) {
    this._email = value;
  }
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public get prenom(): string | undefined {
    return this._prenom;
  }
  public set prenom(value: string | undefined) {
    this._prenom = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  constructor(
    private _id?: number,
    private _prenom?: string,
    private _nom?: string,
    private _email?: string,
    private _dtNaiss?: Date,
    private _adresse?: Adresse,
    private _interne?: boolean,
    private _cout?: number
  ) {}
}
