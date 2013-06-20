package com.mkyong.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
 
@Path("/Person")
public class HelloWorldService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Person> getAllPersonsInJSON() {
		
		 Collection<Person> persons = PersonsManager.getInstance().getAllPersons();
		return persons;
	}
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonInJSON(@PathParam("param") long id) {
		Person person = PersonsManager.getInstance().getPersonById(id);
		return person;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPersonInJSON(Person person) throws JsonMappingException, JsonParseException {
 
		PersonsManager.getInstance().addPerson(person);

		String result = "Person saved : " + person;
		return Response.status(201).entity(result).build();
 
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response changePersonName(@PathParam("id") long id, String name)  {

		String output;

		Person person = (PersonsManager.getInstance()).getPersonById(id);
		String oldName = person.get_name();
				
		boolean success = PersonsManager.getInstance().changePersonName(id, name);
		if (!success){
			
			 output = "There is no person with: " + id + " Id." +
			 		" Maby try a number under:" + PersonsManager.getInstance().getNumberOfPersons() ;	
		}else{
			 output = "The person: " +oldName +", With the id: " + id + " Change his name to: " +name;
		}
		
		return Response.status(201).entity(output).build();
 
	}
	
	@DELETE
	@Path("/{id}")
	public Response cretaPerson(@PathParam("id") long id) {
		
		String output;
		
		Person person = (PersonsManager.getInstance()).getPersonById(id);
		if (person == null){
			output = "There is no person with the id: " + id;
			return Response.status(200).entity(output).build();
		}
		String oldName = person.get_name();
		
		PersonsManager.getInstance().deletePersonById(id);
		
		output = "The person " +oldName + " just been erased";

		return Response.status(Response.Status.ACCEPTED).entity(output).build();
	}
	
	@GET
	@Path("/personsNumber")
	public Response getMsg() {
 
		String output = "There are " + PersonsManager.getInstance().getNumberOfPersons() + " persons";
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Path("/allPersons")
	public Response getAllPersons() {
 
		String output = "There are " + PersonsManager.getInstance().getNumberOfPersons() + " persons /n" +"Persons names are: " +PersonsManager.getInstance().getAllPersons();
 
		return Response.status(200).entity(output).build();
 
	}
	
	
 
}
