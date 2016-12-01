 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Airline;
import Entity.Airport;
import Entity.Flight;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thesoap
 */


public class FlightFacadeTest {

    public FlightFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        FlightFacade FF = new FlightFacade();
        Flight flight = new Flight();
        flight = FF.addFlight(flight);
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
     * Test of addFlight method, of class FlightFacade.
     */
    @Test
    public void testAddFlight() {
        FlightFacade FF = new FlightFacade();
        Flight flight = new Flight();
        flight = FF.addFlight(flight);
        assertEquals(flight.getId(), 3);
    }

    /**
     * Test of getFlight method, of class FlightFacade.
     */
    @Test
    public void testGetFlight() {
        FlightFacade FF = new FlightFacade();
        Flight flight = FF.getFlight(1);
        assertEquals(1, flight.getId());
    }

    /**
     * Test of addAirline method, of class FlightFacade.
     */
    @Test
    public void testAddAirline() {
        FlightFacade FF = new FlightFacade();
        AirlineFacade ALF = new AirlineFacade();
        Airline airline = new Airline();
        Flight flight = new Flight();
        airline = ALF.addAirline(airline);
        flight = FF.addAirline(airline, flight);
        int expResult = airline.getId();
        int result = flight.getAirline().getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of addDestination method, of class FlightFacade.
     */
    @Test
    public void testAddDestination() {
//        System.out.println("addDestination");
//        Airport airport = null;
//        Flight flight = null;
//        FlightFacade instance = new FlightFacade();
//        boolean expResult = false;
//        boolean result = instance.addDestination(airport, flight);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of addOrigin method, of class FlightFacade.
     */
    @Test
    public void testAddOrigin() {
//        System.out.println("addOrigin");
//        Airport airport = null;
//        Flight flight = null;
//        FlightFacade instance = new FlightFacade();
//        boolean expResult = false;
//        boolean result = instance.addOrigin(airport, flight);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
