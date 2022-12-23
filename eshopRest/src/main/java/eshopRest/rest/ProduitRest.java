package eshopRest.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eshop.dao.DaoProduit;
import eshop.entity.Produit;
import eshop.util.JpaContext;

@Path("/produit")
@Produces(MediaType.APPLICATION_JSON)
public class ProduitRest {

	private DaoProduit daoProduit = JpaContext.getDaoProduit();

	@GET
	@Path("")
	public List<Produit> getProduits() {
		return daoProduit.findAll();
	}

//	@GET
//	@Path("/id")
//	public Produit getProduitById(@QueryParam("id") Long id) {
//		Produit p=daoProduit.findByKey(id);
//		if(p==null) {
//			throw new WebApplicationException(Response.Status.NOT_FOUND);
//		}
//		return p;
//	}
	
	@GET
	@Path("/{id}")
	public Response getProduitById(@PathParam("id") Long id) {
		Produit p=daoProduit.findByKey(id);
		if(p==null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return Response.ok(p).build();
	}
	
	//creation
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	public Produit createProduit(Produit produit) {
		daoProduit.insert(produit);
		return produit;
	}
}
