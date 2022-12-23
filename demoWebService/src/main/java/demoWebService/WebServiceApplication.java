package demoWebService;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import demoWebService.restservice.MessageRestService;
import demoWebService.restservice.ProduitWebService;

public class WebServiceApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public WebServiceApplication() {
		singletons.add(new MessageRestService());
		singletons.add(new ProduitWebService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
