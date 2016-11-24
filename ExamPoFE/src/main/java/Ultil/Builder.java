/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultil;

import javax.persistence.Persistence;

/**
 *
 * @author Thesoap
 */
public class Builder {

    public static void main(String[] args) {
        Persistence.generateSchema("FlightDB_PU", null);
    }
}
