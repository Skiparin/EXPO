/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Flight;
import Entity.FlightInstance;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class FlightInstanceFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FlightDB_PU");

    public FlightInstance addFlightInstance(FlightInstance flightinstance) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(flightinstance);
            em.getTransaction().commit();
            return flightinstance;
        } finally {
            em.close();
        }
    }

    public boolean addFlight(Flight flight, FlightInstance flightinstance) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        flight.addFlightInstance(flightinstance);
        flightinstance.setFlight(flight);
        em.merge(flightinstance);
        em.merge(flight);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
