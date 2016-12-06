/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Entity.Flight;
import Entity.Reservation;
import Facades.AirlineFacade;
import Facades.FlightFacade;
import Facades.FlightInstanceFacade;
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
@Path("flight")
public class FlightResource {

    private static final Gson gson = new Gson();
    AirlineFacade facade = new AirlineFacade();
    ReservationFacade resFacade = new ReservationFacade();
    FlightFacade flightFacade = new FlightFacade();
    FlightInstanceFacade fif = new FlightInstanceFacade();
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
//        List<Flight> flights = fif.getFlightByOrigin(FROM, DATE, TICKETS);
//        String jsonFlight = gson.toJson(flights);
//        return jsonFlight;
        return null;
    }

    @GET
    @Path("/get/{from}/{to}/{date}/{tickets}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFlightFromTo(@PathParam("from") String FROM, @PathParam("to") String TO, @PathParam("date") String DATE,
            @PathParam("tickets") int TICKETS) {
        return gson.toJson(facade.getAirlinesWithFlights(FROM, TO, DATE, TICKETS));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{flightId}")
    public Object ReserveFlight(@PathParam("flightId") int id) {
        Reservation res = new Reservation();
        Flight flightId;
        res.setTotalPrice(750);
        flightId = flightFacade.getFlight(id);
        resFacade.addReservation(res);
        gson.toJson(flightId);
        System.out.println(flightId);
        System.out.println(res);
        return flightId;
    }
}
