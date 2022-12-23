package demoWebService.restservice;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.annotate.JsonView;

import demoWebService.model.Fournisseur;
import demoWebService.model.JsonViews;
import demoWebService.model.Produit;

@Path("/produit")
public class ProduitWebService {

	@JsonView(value = JsonViews.Base.class)
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduit() {
		Fournisseur f = new Fournisseur("lll");
		Produit produit = new Produit(1, "mmm", f);
		List<Produit> produits = Arrays.asList(produit);
		f.setProduits(produits);
		return Response.ok(produit).build();

	}

	@JsonView(JsonViews.Base.class)
	@GET
	@Path("/fournisseurAvecProduit")
	@Produces(MediaType.APPLICATION_JSON)
	public Fournisseur getFournisseur() {
		Fournisseur f = new Fournisseur("lll");
		Produit produit = new Produit(1, "mmm", f);
		List<Produit> produits = Arrays.asList(produit);
		f.setProduits(produits);
		return f;

	}
}
