package demoWebService;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import demoWebService.restservice.MessageRestService;

public class WebServiceApplication extends Application{

	private Set<Object> singletons=new HashSet<Object>();
	
	public WebServiceApplication() {
		singletons.add(new MessageRestService());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
