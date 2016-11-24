/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultil;

import Entity.Airport;
import Facades.AirportFacade;

/**
 *
 * @author Thesoap
 */
public class Runner {

    public static void main(String[] args) {
        AirportFacade AF = new AirportFacade();

        Airport airport1 = new Airport();
        airport1.setName("Kastrup");
        AF.addAirport(airport1);
    }

}
