package demoWebService.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Fournisseur {
	private String nom;
	//@JsonIgnore
	List<Produit> produits;

	public Fournisseur() {

	}

	public Fournisseur(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
