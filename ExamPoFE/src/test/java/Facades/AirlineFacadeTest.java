/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Airline;
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
public class AirlineFacadeTest {

    public AirlineFacadeTest() {
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
     * Test of addAirline method, of class AirlineFacade.
     */
    @Test
    public void testAddAirline() {
        AirlineFacade AlF = new AirlineFacade();
        Airline airline = new Airline();
        airline = AlF.addAirline(airline);
        assertEquals(airline.getId(), 1);
    }

}
