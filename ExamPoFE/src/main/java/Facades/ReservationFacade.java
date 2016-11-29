/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Flight;
import Entity.FlightInstance;
import Entity.Reservation;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class ReservationFacade {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FlightDB_PU");

    public Reservation addReservation(Reservation reservation) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(reservation);
            em.getTransaction().commit();
            return reservation;
        } finally {
            em.close();
        }
    }
        public boolean addFlightInstance(FlightInstance flightinstance, Reservation reservation) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        flightinstance.addReservation(reservation);
        reservation.setFlightInstance(flightinstance);
        em.merge(flightinstance);
        em.merge(reservation);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
