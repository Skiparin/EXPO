/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Airline;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class AirlineFacade {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FlightDB_PU");

    public Airline addAirline(Airline airline) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(airline);
            em.getTransaction().commit();
            return airline;
        } finally {
            em.close();
        }
    }
}
