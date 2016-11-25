/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Passenger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class PassengerFacade {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FlightDB_PU");

    public Passenger addPassenger(Passenger passenger) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(passenger);
            em.getTransaction().commit();
            return passenger;
        } finally {
            em.close();
        }
    }
}
