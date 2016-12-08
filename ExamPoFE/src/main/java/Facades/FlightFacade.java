/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Airline;
import Entity.Airport;
import Entity.Flight;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Oliver
 */
public class FlightFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FlightDB_PU");

    public Flight addFlight(Flight flight) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(flight);
            em.getTransaction().commit();
            return flight;
        } finally {
            em.close();
        }
    }

    public Flight getFlight(int ID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Flight flight = em.find(Flight.class, ID);
        em.getTransaction().commit();
        if (flight != null) {
            em.close();
            return flight;
        } else {
            return null;
        }
    }

    public Flight addAirline(Airline airline, Flight flight) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        airline.addFlights(flight);
        flight.setAirline(airline);
        em.merge(airline);
        em.merge(flight);
        em.getTransaction().commit();
        em.close();
        return flight;
    }

    public Flight addDestination(Airport airport, Flight flight) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        airport.addDestination(flight);
        flight.setDestination(airport);
        em.merge(airport);
        em.merge(flight);
        em.getTransaction().commit();
        em.close();
        return flight;
    }

    public Flight addOrigin(Airport airport, Flight flight) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        airport.addOrigin(flight);
        flight.setOrigin(airport);
        em.merge(airport);
        em.merge(flight);
        em.getTransaction().commit();
        em.close();
        return flight;
    }

    public List<Airline> getAllFlights() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Airline> airlines = (TypedQuery<Airline>) em.createNativeQuery("SELECT * FROM flight", Airline.class);
        return airlines.getResultList();
    }
    
}
