/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultil;

import Entity.Airline;
import Entity.Airport;
import Entity.Flight;
import Entity.FlightInstance;
import Entity.Passenger;
import Entity.Reservation;
import Facades.AirlineFacade;
import Facades.AirportFacade;
import Facades.FlightFacade;
import Facades.FlightInstanceFacade;
import Facades.PassengerFacade;
import Facades.ReservationFacade;

/**
 *
 * @author Thesoap
 */
public class Runner {

    public void putData () {
        AirportFacade APF = new AirportFacade();
        AirlineFacade AF = new AirlineFacade();
        FlightFacade FF = new FlightFacade();
        FlightInstanceFacade FIF = new FlightInstanceFacade();
        PassengerFacade PF = new PassengerFacade();
        ReservationFacade RF = new ReservationFacade();
        
        Airport airport1 = new Airport();
        airport1.setCity("Berlin");
        airport1.setCountry("Germany");
        APF.addAirport(airport1);
        
        Airline airline1 = new Airline();
        airline1.setName("WoopWoop");
        AF.addAirline(airline1);
        
        Flight flight1 = new Flight();
        flight1.setFlightNumber("2");
        flight1.setFlightTime(16);
        flight1.setNumberOfSeats(6);
        FF.addFlight(flight1);
        
        FlightInstance flightinstance1 = new FlightInstance();
        flightinstance1.setAvaiableSeats("2");
        flightinstance1.setDate("2. maj");
        flightinstance1.setPrice(500);
        flightinstance1.setTime("11:11:2016");
        FIF.addFlightInstance(flightinstance1);
        
        Passenger passenger1 = new Passenger();
        passenger1.setFirstName("Ole");
        passenger1.setLastName("Hansen");
        PF.addPassenger(passenger1);
        
        Reservation reservation1 = new Reservation();
        reservation1.setTotalPrice(750);
        RF.addReservation(reservation1);
    }
    
    public static void main(String[] args) {
        AirportFacade AF = new AirportFacade();
        AirlineFacade AlF = new AirlineFacade();
        FlightFacade FF = new FlightFacade();
        FlightInstanceFacade FIF = new FlightInstanceFacade();

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
        
        
        Runner runner = new Runner();
        runner.putData();
    }

}
