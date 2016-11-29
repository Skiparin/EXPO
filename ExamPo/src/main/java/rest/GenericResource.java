/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.Airline;
import facades.AirlineFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import runnable.HttpGetTask;
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    @Path("/todo/{from}/{to}/{date}/{persons}")
    public String getFlights(@PathParam("from") String FROM, @PathParam("to") String TO,
            @PathParam("date") String DATE, @PathParam("persons") String PERSONS) {
        List<Airline> list = facade.getAllAirlines();
        String json = "[";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUrl() != null) {

                try {
                    DefaultHttpClient httpClient = new DefaultHttpClient();

                    HttpGet GetRequest = new HttpGet(list.get(i).getUrl() + FROM + "/" + TO + "/" + DATE + "/" + PERSONS);
                    System.out.println(GetRequest.getURI());
                    HttpResponse response = httpClient.execute(GetRequest);

                    BufferedReader br = new BufferedReader(
                            new InputStreamReader((response.getEntity().getContent())));

                    String output;
                    while ((output = br.readLine()) != null) {
                        json = json.concat(output);
                        System.out.println(json);
                    }
                    if ((i + 1) != list.size()) {
                        json = json.concat(",");
                    }
                    httpClient.getConnectionManager().shutdown();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        json = json.concat("]");
        return json;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/todo/{from}/{date}/{persons}")
    public String getFlights(@PathParam("from") String FROM, @PathParam("date") String DATE,
            @PathParam("persons") String PERSONS) {
        String json = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet GetRequest = new HttpGet("http://airline-plaul.rhcloud.com/api/flightinfo/" + FROM + "/" + DATE + "/" + PERSONS);

            HttpResponse response = httpClient.execute(GetRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            while ((output = br.readLine()) != null) {
                json = json.concat(output);
                System.out.println(json);
            }
            httpClient.getConnectionManager().shutdown();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return json;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/todoo/{from}/{to}/{date}/{persons}")
    public String getFlightss(@PathParam("from") String FROM, @PathParam("to") String TO,
            @PathParam("date") String DATE, @PathParam("persons") String PERSONS) {
        List<Airline> list = facade.getAllAirlines();
        List<Future> futures = new ArrayList<>();
        ExecutorService threadpool = Executors.newFixedThreadPool(list.size());
        String params = FROM + "/" + TO + "/" + DATE + "/" + PERSONS;
        String json = "[";
        
        for (Airline airline : list) {
            futures.add(threadpool.submit(new HttpGetTask(airline.getUrl() + params)));
        }
        
        while(!allDone(futures)){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
        for (Future future : futures) {
            try {
                json = json.concat((String) future.get());
                json = json.concat(",");
            } catch (InterruptedException ex) {
                Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        json = json.substring(0, json.length() - 1);
        json = json.concat("]");
        return json;
        
    }

    
    public boolean allDone(List<Future> list){
        int size = list.size();
        int count = 0;
        
        for (Future task : list) {
            if(task.isDone()){
                count++;
            }
        }
        if(size == count){
            return true;
        }
        return false;
    }
}
