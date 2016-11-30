/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.FlightInstance;
import Entity.Passenger;
import Entity.Reservation;
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
public class ReservationFacadeTest {
    
    public ReservationFacadeTest() {
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
     * Test of addReservation method, of class ReservationFacade.
     */
    @Test
    public void testAddReservation() {
        ReservationFacade RF = new ReservationFacade();
        Reservation reservation = new Reservation();
        reservation = RF.addReservation(reservation);
        assertEquals(reservation.getId(), 1);
    }

    /**
     * Test of getReservation method, of class ReservationFacade.
     */
    @Test
    public void testGetReservation() {
        System.out.println("getReservation");
        int ID = 0;
        ReservationFacade instance = new ReservationFacade();
        Reservation expResult = null;
        Reservation result = instance.getReservation(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFlightInstance method, of class ReservationFacade.
     */
    @Test
    public void testAddFlightInstance() {
        System.out.println("addFlightInstance");
        FlightInstance flightinstance = null;
        Reservation reservation = null;
        ReservationFacade instance = new ReservationFacade();
        boolean expResult = false;
        boolean result = instance.addFlightInstance(flightinstance, reservation);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
