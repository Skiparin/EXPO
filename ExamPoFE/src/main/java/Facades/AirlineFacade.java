/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Airline;
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

    public Airline getAirline(int ID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Airline airline = em.find(Airline.class, ID);
        em.getTransaction().commit();
        if (airline != null) {
            em.close();
            return airline;
        } else {
            return null;
        }
    }
    
    public List<Airline> getAirlinesWithFlights(String FROM, String TO, String DATE, int TICKETS){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Airline> airlines = (TypedQuery<Airline>) em.createNativeQuery("SELECT * FROM airline", Airline.class);
        List<Airline> list = airlines.getResultList();
        for (Airline airline : list) {
            System.out.println("----------------------------------------------------------");
            System.out.println(airline);
            System.out.println(airline.getFlights());
        }
        list = removeFlights(list, FROM, TO, DATE, TICKETS);
        return list;
    }
    
    public List<Airline> removeFlights(List<Airline> list, String FROM, String TO, String DATE, int TICKETS){
        for (Airline airline : list) {
            for (Flight flight : airline.getFlights()) {
                if(!(flight.getOrigin().equals(FROM) && flight.getDestination().equals(TO) && flight.getFlightTime().equals(DATE) && flight.getNumberOfSeats() >= TICKETS)){
                    airline.getFlights().remove(flight);
                }
            }
        }
        return list;
    }
    
}
