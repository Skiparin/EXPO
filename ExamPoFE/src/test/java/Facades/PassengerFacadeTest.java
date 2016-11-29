/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.FlightInstance;
import Entity.Passenger;
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
public class PassengerFacadeTest {

    public PassengerFacadeTest() {
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
     * Test of addPassenger method, of class PassengerFacade.
     */
    @Test
    public void testAddPassenger() {
        PassengerFacade PF = new PassengerFacade();
        Passenger passenger = new Passenger();
        passenger = PF.addPassenger(passenger);
        assertEquals(passenger.getId(), 1);
    }

}
