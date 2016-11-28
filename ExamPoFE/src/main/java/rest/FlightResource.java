/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Entity.Flight;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import javax.persistence.Persistence;


/**
 * REST Web Service
 *
 * @author Thesoap
 */
@Path("Flight")
public class FlightResource {

    private static final Gson gson = new Gson();
    private Facade facade = new Facade(Persistence.createEntityManagerFactory("FlightDB_PU"));

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
        List<Flight> flights = facade.getFlightByOrigin(FROM, DATE, TICKETS);
        String jsonFlight = gson.toJson(flights);
        return jsonFlight;
    }

    @GET
    @Path("{from}/{to}/{date}/{tickets}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFlightFromTo(@PathParam("from") String FROM, @PathParam("to") String TO, @PathParam("date") String DATE,
            @PathParam("tickets") int TICKETS) {
        List<Flight> flights = facade.getFlight(FROM, TO, DATE, TICKETS);
        String flight = gson.toJson(flights);
        return flight;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("flightId")
    public int ReserveFlight(@PathParam("id") int id) {
        flightId fId = facade.getFlightById(id);
        gson.toJson(fId);
        return fId;
    }
}
