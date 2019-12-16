package edu.rfs;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//NOTE: Most of this code is HEAVILY inspired by the examples from the lectures, if not directly drawn from

@Path("example")
public class TestEndPoint {

	/**
	 * Basic endpoint, to access use application path to the class.  Host
	 * and port can vary with your specific Tomcat install
	 * 
	 * http://localhost:8080/JerseyExample/webresources/example
	 *
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamText() {
		return "SUCCESSFUL OUTPUT FROM SERVICE!!";
	}
	
	/**
	 * Endpoint to demo PathParams, to access use application path to the class.  Host
	 * and port can vary with your specific Tomcat install
	 * 
	 * http://localhost:8080/JerseyExample/webresources/example/params/VALUE
	 * 
	 * VALUE is any value you provide
	 *
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/params/{id}")
	public String getParamText(@PathParam("id") String id) {
		return "The value of the path parameter is " + id;
	}
	
	/**
	 * Endpoint to demo PathParams and QueryParams, to access use application path
	 * and query parameters to the class.  Host and port can vary with your specific
	 * Tomcat install
	 * 
	 * http://localhost:8080/JerseyExample/webresources/example/params2/VALUE?zip=zipValue
	 * 
	 * VALUE is any value you wish
	 * zipValue is a value for zipcode
	 *
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/params2/{id}")
	public String getParamText(@PathParam("id") String id, @QueryParam("zip") int zipCode) {
		return "The value of the path parameter is " + id + " with a zip code of " + zipCode;
	}
		
	/**
	 * Endpoint to demo FormParams, to access data passed from a form to enpoint.
	 * Utilizes the index.html page in this application.  Host and port can vary with your specific
	 * Tomcat install.
	 * 
	 * http://localhost:8080/JerseyExample/index.html to access form 
	 * 
	 * Submit form above to test example endpoint
	 */
	@POST
	@Path("/formtest")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamText(@FormParam("username") String user, @FormParam("password") String pw) {
		return "The value of the form parameters are username = " + user + " and password = " + pw;
	}
	
	@POST
	@Path("/hikecheck")
	@Produces(MediaType.TEXT_HTML)
	public String getHikeText(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName, @FormParam("hikingOption") String hikingOption, @FormParam("partySize") int partySize) {
		if ((partySize < 1) || (partySize > 10)) {
			return "Please pick a valid party size!";
		} else {
			return "Potential hiker, " + firstName + " " + lastName + ", wants to hike " + hikingOption + " with a party of " + partySize;
		}
	}

}