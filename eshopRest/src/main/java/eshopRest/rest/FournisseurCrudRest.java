package eshopRest.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eshop.dao.DaoFournisseur;
import eshop.dao.DaoProduit;
import eshop.entity.Adresse;
import eshop.entity.Fournisseur;
import eshop.util.JpaContext;

@Path("/fournisseur")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FournisseurCrudRest {

	private DaoFournisseur daoFournisseur = JpaContext.getDaoFournisseur();
	private DaoProduit daoProduit = JpaContext.getDaoProduit();

	@Path("")
	@GET
	public List<Fournisseur> findAll() {
		return daoFournisseur.findAll();
	}

	@Path("/{id}")
	@GET
	public Fournisseur findById(@PathParam("id") Long id) {
		return getById(id);
	}

	private Fournisseur getById(Long id) {
		Fournisseur f = daoFournisseur.findByKey(id);
		if (f == null) {
			throw new WebApplicationException("fournisseur inconnu", Response.Status.NOT_FOUND);
		}
		return f;
	}

	@POST
	@Path("")
	public Fournisseur create(Fournisseur fournisseur) {
		daoFournisseur.insert(fournisseur);
		return fournisseur;
	}

	@DELETE
	@Path("/{id}")
	public void deleteById(@PathParam("id") Long id) {
		// si le fournisseur est rattache à un produit
//		Fournisseur f = daoFournisseur.findByKeyFetchProduits(id);
//		if (f == null) {
//			throw new WebApplicationException("fournisseur inconnu", Response.Status.NOT_FOUND);
//		}
//		f.getProduits().stream().forEach(p -> {
//			// 1=>on supprime le produit
//			//daoProduit.delete(p);
//			// 2=>on change le fournisseur du produit
//			p.setFournisseur(null);
//			daoProduit.update(p);
//		});
//
//		daoFournisseur.deleteByKey(f.getId());
		Fournisseur f=findById(id);
		//on met le fournisseur à null
		daoProduit.setFournisseurToNull(f);
		//on supprime les produits associes
		//daoProduit.deleteByFournisseur(f);
		daoFournisseur.delete(f);
	}

	@PUT
	@Path("/{id}")
	public Fournisseur update(@PathParam("id") Long id, Fournisseur fournisseur) {
		Fournisseur fournisseurEnBase = getById(id);
		fournisseurEnBase.setNom(fournisseur.getNom());
		fournisseurEnBase.setEmail(fournisseur.getEmail());
		if (fournisseur.getAdresse() != null) {
			Adresse adresse = fournisseur.getAdresse();
			fournisseurEnBase.setAdresse(
					new Adresse(adresse.getNumero(), adresse.getRue(), adresse.getCodePostal(), adresse.getVille()));
		} else {
			fournisseurEnBase.setAdresse(null);
		}
		fournisseurEnBase.setContact(fournisseur.getContact());
		return daoFournisseur.update(fournisseurEnBase);
	}
}
