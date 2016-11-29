/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Flight;
import Entity.FlightInstance;
import java.util.ArrayList;
import java.util.List;
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

    public FlightInstance getFlightInstance(int ID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        FlightInstance flightInstance = em.find(FlightInstance.class, ID);
        em.getTransaction().commit();
        if (flightInstance != null) {
            em.close();
            return flightInstance;
        } else {
            return null;
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

    public List<FlightInstance> getFromAPI(String from, String date, int tickets) {
        EntityManager em = emf.createEntityManager();
        List<FlightInstance> FI = new ArrayList();
        
        em.getTransaction().begin();
        em.getTransaction().commit();
        return FI;
        
    }
}
