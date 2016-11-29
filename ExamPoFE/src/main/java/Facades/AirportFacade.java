/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Airport;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thesoap
 */
public class AirportFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FlightDB_PU");

    public Airport addAirport(Airport airport) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(airport);
            em.getTransaction().commit();
            return airport;
        } finally {
            em.close();
        }
    }

    public Airport getAirport(int ID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Airport airport = em.find(Airport.class, ID);
        em.getTransaction().commit();
        if (airport != null) {
            em.close();
            return airport;
        } else {
            return null;
        }
    }
}
