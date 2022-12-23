package demoWebService.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

//definition URL du service
@Path("/message/hello")
public class MessageRestService {

	@GET
	@Path("")
	public Response helloMessage() {
		//Response =>la reponse renvoye
		//doit avoir un status http
		//peut avoir un contenu=>object
		return Response.status(200).entity("hello word").build();
	}
	
	@GET
	@Path("/bye")
	public Response goodbye() {
		return Response.status(200).entity("goodbye").build();
	}

}
