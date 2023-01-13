export class Produit {
  public get prix(): number {
    return this._prix;
  }
  public set prix(value: number) {
    this._prix = value;
  }
  public get libelle(): string | undefined {
    return this._libelle;
  }
  public set libelle(value: string | undefined) {
    this._libelle = value;
  }
  constructor(private _libelle?: string, private _prix: number = 0) {}
}
