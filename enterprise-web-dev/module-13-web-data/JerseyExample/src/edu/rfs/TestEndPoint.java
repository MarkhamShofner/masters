package edu.rfs;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


//NOTE: Most of this code is HEAVILY inspired by the examples from the lectures, if not directly drawn from
// I also ran into a roadblock and used one of the other student's solutions to see how to get past the formsend issues I was having

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
	
//	@GET
//	@Path("/toJson")
//	@Produces(MediaType.APPLICATION_JSON)
//	public JacksonObject getObject() {
//		JacksonObject jo = new JacksonObject();
//		jo.setFirstName("Markham");
//		jo.setLastName("Shofner");
//		jo.setAge(31);
//
//		return jo;
//	}
	
	@GET
	@Path("/toJson")
	@Produces(MediaType.APPLICATION_JSON)
	public JacksonObject getObject() {
		JacksonObject jo = new JacksonObject();
		jo.setHikingOption("Hellroaring");
		jo.setStartDate(25);
		jo.setDurationOption(31);
		jo.setPartySize(5);


		return jo;
	}
	
	@POST
	@Path("/toObject")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setObject(JacksonObject t) {
		// TODO: put it in the response object, not as a tag
		// pass into the .ok() and serialize as a parameter?
//		return Response.ok().tag(t.toString()).build();
		return Response.ok(t.toString()).build();
	}
	

//	import com.fasterxml.jackson.core.JsonProcessingException;
//	import com.fasterxml.jackson.databind.ObjectMapper;
//	import com.fasterxml.jackson.core.JsonParseException;
//	import com.fasterxml.jackson.databind.JsonMappingException;
//	import java.io.IOException;
	
	// extend the Web Service you created in that assignment to accept input in the form of a JSON string (that gets deserialized into a Java object) and generates a JSON response back to the client who will use it's content to update page on the client
	
	
}