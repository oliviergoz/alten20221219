package eshopRest.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eshop.dao.DaoProduit;
import eshop.entity.Produit;
import eshop.util.JpaContext;

@Path("/produit")
public class ProduitRest {

	private DaoProduit daoProduit = JpaContext.getDaoProduit();

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getProduits() {
		return daoProduit.findAll();
	}
}
