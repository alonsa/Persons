package com.mkyong.rest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: alon.shalom
 * Date: 6/24/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonsManagerTest {
    @BeforeMethod
    public void setUp() throws Exception {
               System.out.println("Is setting UP, PersonsManagerTest");

//        testAddPerson();
    }

    @Test
    public void testAddPerson() throws Exception {
        System.out.println("Testing: AddPerson");


    }

    @Test
    public void testGetNumberOfPersons() throws Exception {
        System.out.println("Testing: GetNumberOfPersons");


    }

    @Test
    public void testGetAllPersons() throws Exception {
        System.out.println("Testing: GetAllPersons");


    }

    @Test
    public void testGetPersonById() throws Exception {
        System.out.println("Testing: GetPersonById");

    }
}
