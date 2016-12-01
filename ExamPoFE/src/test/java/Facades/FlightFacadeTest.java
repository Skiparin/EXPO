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
        assertEquals(flight.getId(), 4);
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
        FlightFacade FF = new FlightFacade();
        AirportFacade APF = new AirportFacade();
        Airport airport = new Airport();
        Flight flight = new Flight();
        airport = APF.addAirport(airport);
        flight = FF.addDestination(airport, flight);
        int expResult = airport.getId();
        int result = flight.getDestination().getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of addOrigin method, of class FlightFacade.
     */
    @Test
    public void testAddOrigin() {
        FlightFacade FF = new FlightFacade();
        AirportFacade APF = new AirportFacade();
        Airport airport = new Airport();
        Flight flight = new Flight();
        airport = APF.addAirport(airport);
        flight = FF.addOrigin(airport, flight);
        int expResult = airport.getId();
        int result = flight.getOrigin().getId();
        assertEquals(expResult, result);
    }

}
