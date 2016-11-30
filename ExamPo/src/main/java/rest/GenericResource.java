/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.Airline;
import facades.AirlineFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import runnable.HttpGetTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;

/**
 * REST Web Service
 *
 * @author Orvur
 */
@Path("flight")
public class GenericResource {

    private static final Gson gson = new Gson();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamPo");
    AirlineFacade facade = new AirlineFacade(emf);

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
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
    @Produces(MediaType.TEXT_HTML)
    @Path("/get/{from}/{date}/{persons}")
    public String getFlights(@PathParam("from") String FROM, @PathParam("date") String DATE,
            @PathParam("persons") String PERSONS) {
        List<Airline> list = facade.getAllAirlines();
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService threadpool = Executors.newFixedThreadPool(list.size());
        String params = FROM + "/" + DATE + "/" + PERSONS;
        String json = "[";

        for (Airline airline : list) {
            futures.add(threadpool.submit(new HttpGetTask(airline.getUrl() + params)));
        }

        String smarterJson = futures.stream().<String>map(future -> {
            try {
                return future.get();
            } catch (Exception ex) {
                throw new RuntimeException("");
            }
        }).parallel().collect(Collectors.joining(","));

        json = json.concat(smarterJson + "]");
        return json;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/get/{from}/{to}/{date}/{persons}")
    public String getFlights(@PathParam("from") String FROM, @PathParam("to") String TO,
            @PathParam("date") String DATE, @PathParam("persons") String PERSONS) {
        List<Airline> list = facade.getAllAirlines();
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService threadpool = Executors.newFixedThreadPool(list.size());
        String params = FROM + "/" + TO + "/" + DATE + "/" + PERSONS;
        String json = "[";

        for (Airline airline : list) {
            futures.add(threadpool.submit(new HttpGetTask(airline.getUrl() + params)));
        }

        String smarterJson = futures.stream().<String>map(future -> {
            try {
                return future.get();
            } catch (Exception ex) {
                throw new RuntimeException("");
            }
        }).parallel().collect(Collectors.joining(","));

        json = json.concat(smarterJson + "]");
        return json;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{from}/{to}/{date}/{persons}")
    public String getFlights(@PathParam("from") String FROM, @PathParam("to") String TO,
            @PathParam("date") String DATE, @PathParam("persons") String PERSONS) {
        List<Airline> list = facade.getAllAirlines();
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService threadpool = Executors.newFixedThreadPool(list.size());
        String params = FROM + "/" + TO + "/" + DATE + "/" + PERSONS;
        String json = "[";

        for (Airline airline : list) {
            futures.add(threadpool.submit(new HttpGetTask(airline.getUrl() + params)));
        }

        String smarterJson = futures.stream().<String>map(future -> {
            try {
                return future.get();
            } catch (Exception ex) {
                throw new RuntimeException("");
            }
        }).parallel().collect(Collectors.joining(","));

        json = json.concat(smarterJson + "]");
        return json;

    }

}
