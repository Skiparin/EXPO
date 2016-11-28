/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Airline;
import Entity.Airport;
import Entity.Flight;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

    public boolean addAirline(Airline airline, Flight flight) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        airline.setFlights(flight);
        flight.setAirline(airline);
        em.merge(airline);
        em.merge(flight);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public boolean addDestination(Airport airport, Flight flight) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        airport.setDestination(flight);
        flight.setDestination(airport);
        em.merge(airport);
        em.merge(flight);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public boolean addOrigin(Airport airport, Flight flight) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        airport.setOrigin(flight);
        flight.setOrigin(airport);
        em.merge(airport);
        em.merge(flight);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
