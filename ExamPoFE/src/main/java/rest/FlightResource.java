/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Entity.Flight;
import Facades.ReservationFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import javax.ws.rs.Consumes;


/**
 * REST Web Service
 *
 * @author Thesoap
 */
@Path("Flight")
public class FlightResource {

    private static final Gson gson = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FlightResource
     */
    public FlightResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     *
     * @param FROM
     * @param DATE
     * @param TICKETS
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{from}/{date}/{tickets}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFlightFrom(@PathParam("from") String FROM, @PathParam("date") String DATE,
            @PathParam("tickets") int TICKETS) {
        return null;
    }

    @GET
    @Path("{from}/{to}/{date}/{tickets}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFlightFromTo(@PathParam("from") String FROM, @PathParam("to") String TO, @PathParam("date") String DATE,
            @PathParam("tickets") int TICKETS) {
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("flightId")
    public Object ReserveFlight(@PathParam("id") int id) {
        ReservationFacade resFacade = new ReservationFacade();
        Flight flightId = gson.fromJson(resFacade.addReservation(reservation), Flight.class);
        gson.toJson(flightId);
        return flightId;
    }
}
