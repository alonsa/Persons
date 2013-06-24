package com.mkyong.rest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: alon.shalom
 * Date: 6/24/13
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldServiceTest {

    HelloWorldService _helloWorldService = new  HelloWorldService();
    private static String NAME = "alon";

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("Is setting UP, HelloWorldServiceTest");

//        deleteAll();

        testFirstTimeGetAllPersonsInJSON();
        testCreatePersonInJSON();
        testGetAllPersonsInJSON();
        testGetPersonInJSON();
//        testChangePersonName();

    }

//    private void deleteAll() throws UnknownHostException {
//        Collection<Person> persons = PersonsManager.getInstance().getAllPersons();
//        for (Person person : persons){
//            _helloWorldService.deletePerson(person.get_id());
//        }
//
//    }

    @Test
    public void testFirstTimeGetAllPersonsInJSON() throws Exception {
        System.out.println("First time try to Get All Persons");
        Collection<Person> peresons = _helloWorldService.getAllPersonsInJSON();

        Assert.assertEquals(peresons.isEmpty(), true);
    }

    @Test
    public void testCreatePersonInJSON() throws Exception {
        System.out.println("Create Person In JSON");
        Person person = new Person(NAME);
        Response returnVal = _helloWorldService.createPersonInJSON(person);

        Assert.assertEquals(returnVal.getStatus(), Response.Status.CREATED.getStatusCode());
    }

    @Test
    public void testGetAllPersonsInJSON() throws Exception {
        System.out.println("Get All Persons");
        Collection<Person> tempPeresons = _helloWorldService.getAllPersonsInJSON();

        Assert.assertEquals(tempPeresons.size(), 1);
    }

    @Test
    public void testGetPersonInJSON() throws Exception {
        System.out.println("Get Person: 1");
        Person person = _helloWorldService.getPersonInJSON(1);

        Assert.assertEquals(person.get_id(), 1);

    }

//    @Test
//    public void testChangePersonName() throws Exception {
//        System.out.println("Change Person Name");
//        Collection<Person> persons = PersonsManager.getInstance().getAllPersons();
//        persons.iterator().next().get_id() ;
//        Person tempPerson = new Person("_"+NAME);
//
//        Response returnVal = _helloWorldService.changePersonName(persons.iterator().next().get_id(), tempPerson);
//
//        Assert.assertEquals(returnVal.getStatus(), Response.Status.OK.getStatusCode());
//    }

}
