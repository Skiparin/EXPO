/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Orvur
 */
public class GenericResourceTest {
    
    public GenericResourceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFlights method, of class GenericResource.
     */
    @Test
    public void testGetFlights_3args() {
        System.out.println("getFlights");
        String FROM = "";
        String DATE = "";
        String PERSONS = "";
        GenericResource instance = new GenericResource();
        String expResult = "";
        String result = instance.getFlights(FROM, DATE, PERSONS);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlights method, of class GenericResource.
     */
    @Test
    public void testGetFlights_4args() {
        System.out.println("getFlights");
        String FROM = "";
        String TO = "";
        String DATE = "";
        String PERSONS = "";
        GenericResource instance = new GenericResource();
        String expResult = "";
        String result = instance.getFlights(FROM, TO, DATE, PERSONS);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
