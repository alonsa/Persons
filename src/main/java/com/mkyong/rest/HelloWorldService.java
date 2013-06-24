package com.mkyong.rest;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.UnknownHostException;
import java.util.Collection;

@Path("/person")
@Service
@Scope("request")
public class HelloWorldService implements ApplicationContextAware {
    // http://localhost:8080/rest/Person/

    @Autowired
    private PersonsManager personsManager;

    @Autowired
    private ApplicationContext ctx;

//    {
////        ApplicationContext springBean = new ClassPathXmlApplicationContext("/Beans.xml");
////        personsManager =(PersonsManager)springBean.getBean("PersonsManager");
//
//        ApplicationContext springAnotationBean = new ClassPathXmlApplicationContext("/AnnotationBeans.xml");
//        personsManager =(PersonsManager)springAnotationBean.getBean("PersonsManager");
//        System.out.println(personsManager.toString());
//    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Person> getAllPersonsInJSON() throws UnknownHostException {

        Collection<Person> persons = personsManager.getAllPersons();
		return persons;
	}

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonInJSON(@PathParam("param") long id) {
		Person person = personsManager.getPersonById(id);
		if (person == null){
            System.out.println("No person found with ID:" + id);
        }
        return person;
	}

	@POST
        @Consumes(MediaType.APPLICATION_JSON)
	public Response createPersonInJSON(Person person) throws JsonMappingException, JsonParseException {

        personsManager.addPerson(person);


		String result = "Person saved : " + person;
		return Response.status(Response.Status.CREATED).entity(result).build();

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response changePersonName(@PathParam("id") long id, Person updatePerson)  {

		String output;

		Person person = (personsManager).getPersonById(id);


		boolean success = personsManager.changePersonName(id, updatePerson.get_name());
		if (person == null && !success){

			 output = "There is no person with: " + id + " Id." +
			 		" Maby try a number under:" + personsManager.getNumberOfPersons() ;
		}else{
            String oldName = person.get_name();
			 output = "The person: " +oldName +", With the id: " + id + " Change his name to: " +updatePerson.get_name();
		}

		return Response.status(Response.Status.OK).entity(output).build();

	}

	@DELETE
	@Path("/{id}")
	public Response deletePerson(@PathParam("id") long id) {

		String output;

		Person person = (personsManager).getPersonById(id);
		if (person == null){
			output = "There is no person with the id: " + id;
			return Response.status(Response.Status.NO_CONTENT).entity(output).build();
		}
		String oldName = person.get_name();

        personsManager.deletePersonById(id);

		output = "The person " +oldName + " just been erased";

		return Response.status(Response.Status.OK).entity(output).build();
	}

	@GET
	@Path("/personsNumber")
	public Response getMsg() {

		String output = "There are " + personsManager.getNumberOfPersons() + " persons";

		return Response.status(Response.Status.ACCEPTED).entity(output).build();

	}

	@GET
	@Path("/allPersons")
	public Response getAllPersons() throws UnknownHostException {

		String output = "There are " + personsManager.getNumberOfPersons() + " persons: " + personsManager.getAllPersons();

		return Response.status(Response.Status.ACCEPTED).entity(output).build();

	}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
