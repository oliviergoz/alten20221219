package demoWebService.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonView;

public class Produit {
	@JsonView(value=JsonViews.Base.class)
	private int numero;
	@JsonProperty("toto")
	private String nom;
	@JsonIgnore
	private Fournisseur fournisseur;

	public Produit() {

	}

	public Produit(int numero, String nom) {
		super();
		this.numero = numero;
		this.nom = nom;
	}

	public Produit(int numero, String nom, Fournisseur fournisseur) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.fournisseur = fournisseur;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

}
