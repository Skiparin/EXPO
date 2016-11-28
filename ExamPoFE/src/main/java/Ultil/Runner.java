/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultil;

import Entity.Airline;
import Entity.Airport;
import Entity.Flight;
import Facades.AirlineFacade;
import Facades.AirportFacade;
import Facades.FlightFacade;

/**
 *
 * @author Thesoap
 */
public class Runner {

    public static void main(String[] args) {
        AirportFacade AF = new AirportFacade();
        AirlineFacade AlF = new AirlineFacade();
        FlightFacade FF = new FlightFacade();

        Airport airport1 = new Airport();
        airport1.setName("Kastrup");
        AF.addAirport(airport1);
        Airport airport2 = new Airport();
        airport2.setName("Berlin");
        AF.addAirport(airport2);
        
        Airline airline1 = new Airline();
        airline1.setName("SAS");
        AlF.addAirline(airline1);
        
        Flight flight1 = new Flight();
        flight1.setFlightTime(20);
        FF.addFlight(flight1);
        
        FF.addDestination(airport1,flight1);
        FF.addOrigin(airport2, flight1);
        FF.addAirline(airline1, flight1);
        
        
    }

}
