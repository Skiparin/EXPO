/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Passenger;
import Entity.Reservation;
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

    public boolean addReservation(Reservation reservation, Passenger passenger) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        passenger.setReservation(reservation);
        reservation.addPassengers(passenger);
        em.merge(passenger);
        em.merge(reservation);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
