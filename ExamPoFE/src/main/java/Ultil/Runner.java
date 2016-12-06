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
        airport1.setIATACode("Code123");
        airport1.setTimezone("PCT+3");
        airport1.setName("wuupDeWuup");
        APF.addAirport(airport1);
        Airport airport2 = new Airport();
        airport2.setCity("Rom");
        airport2.setCountry("Italy");
        airport2.setIATACode("Code321");
        airport2.setTimezone("PCT-5");
        airport2.setName("Boop");
        APF.addAirport(airport2);
        
        Airline airline1 = new Airline();
        airline1.setName("WoopWoop");
        AF.addAirline(airline1);
        
        Flight flight1 = new Flight();
        flight1.setFlightNumber("2");
        flight1.setFlightTime("2017-01-01T15:00:00.000Z");
        flight1.setNumberOfSeats(6);
        flight1.setDestination(airport1);
        flight1.setOrigin(airport1);
        FF.addFlight(flight1);
        FF.addAirline(airline1, flight1);
        FF.addDestination(airport2, flight1);
        FF.addOrigin(airport1, flight1);
        
        FlightInstance flightinstance1 = new FlightInstance();
        flightinstance1.setAvaiableSeats("2");
        flightinstance1.setDate("2. maj");
        flightinstance1.setPrice(500);
        flightinstance1.setTime("2017-01-01T15:00:00.000Z");
        FIF.addFlightInstance(flightinstance1);
        FIF.addFlight(flight1, flightinstance1);
        
        Reservation reservation1 = new Reservation();
        reservation1.setTotalPrice(750);
        RF.addReservation(reservation1);
        RF.addFlightInstance(flightinstance1, reservation1);
        
        Passenger passenger1 = new Passenger();
        passenger1.setFirstName("Ole");
        passenger1.setLastName("Hansen");
        PF.addPassenger(passenger1);
        PF.addReservation(reservation1, passenger1);
    }
    
    public static void main(String[] args) {
        AirportFacade AF = new AirportFacade();
        AirlineFacade ALF = new AirlineFacade();
        FlightFacade FF = new FlightFacade();
        FlightInstanceFacade FIF = new FlightInstanceFacade();
        PassengerFacade PF = new PassengerFacade();
        ReservationFacade RF = new ReservationFacade();
        
//        Airline airline = new Airline();
//        airline.setName("Hej");
//        ALF.addAirline(airline);
//        
//        Airport airport = new Airport();
//        airport.setName("kalk");
//        AF.addAirport(airport);
//        
//        Flight flight = new Flight();
//        flight.setFlightNumber("ihsdfihodfs");
//        FF.addFlight(flight);
//        
//        FlightInstance flightInstance = new FlightInstance();   
//        flightInstance.setDate("27/13-12");
//        FIF.addFlightInstance(flightInstance);
//        
//        Passenger passenger = new Passenger();
//        passenger.setFirstName("Kim");
//        PF.addPassenger(passenger);
//        
//        Reservation reservation = new Reservation();
//        reservation.setTotalPrice(200);
//        RF.addReservation(reservation);
        
        

        // FF.addDestination(airport, flight);
        
        // FF.addAirline(airline, flight);
        Runner runner = new Runner();
        runner.putData();
    }

}
