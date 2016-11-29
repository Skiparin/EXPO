/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Airline;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Orvur
 */
public class AirlineFacade {

    EntityManagerFactory emf;

    public AirlineFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void createAirline(Airline airline) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(airline);
        em.getTransaction().commit();
    }

    public List<Airline> getAllAirlines() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Airline> airlines = (TypedQuery<Airline>) em.createNativeQuery("SELECT * FROM airline", Airline.class);
        return airlines.getResultList();
    }
}
