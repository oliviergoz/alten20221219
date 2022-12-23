package eshopRest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import eshopRest.rest.FournisseurCrudRest;
import eshopRest.rest.ProduitRest;

public class LoadRestServiceApplication extends Application{

	private Set<Object> singletons=new HashSet<Object>();
	
	public LoadRestServiceApplication() {
		singletons.add(new ProduitRest());
		singletons.add(new FournisseurCrudRest());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
