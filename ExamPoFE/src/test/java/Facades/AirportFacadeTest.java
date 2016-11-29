/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Airport;
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
public class AirportFacadeTest {
    
    public AirportFacadeTest() {
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
     * Test of addAirport method, of class AirportFacade.
     */
    @Test
    public void testAddAirport() {
        AirportFacade ApF = new AirportFacade();
        Airport airport = new Airport();
        airport = ApF.addAirport(airport);
        assertEquals(airport.getId(), 1);
    }
    
}
