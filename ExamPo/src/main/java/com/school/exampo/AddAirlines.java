/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.exampo;

import entity.Airline;
import facades.AirlineFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Orvur
 */
public class AddAirlines {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamPo");
        AirlineFacade facade = new AirlineFacade(emf);
        Airline airline = new Airline();
        airline.setName("Demo");
        airline.setUrl("http://airline-plaul.rhcloud.com/api/flightinfo/");

        Airline airline1 = new Airline();
        airline1.setName("Demo1");
        airline1.setUrl("http://airline-plaul.rhcloud.com/api/flightinfo/");

        Airline airline2 = new Airline();
        airline2.setName("Demo2");
        airline2.setUrl("http://airline-plaul.rhcloud.com/api/flightinfo/");

        facade.createAirline(airline);
        facade.createAirline(airline1);
        facade.createAirline(airline2);
    }
}
