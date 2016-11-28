/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import javax.json.Json;
import javax.ws.rs.Consumes;
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
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Orvur
 */
@Path("flight")
public class GenericResource {

    private static final Gson gson = new Gson();

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
    @Path("{from}/{date}/{tickets}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFlightFrom(@PathParam("from") String FROM, @PathParam("date") String DATE,
            @PathParam("tickets") int TICKETS) {
        Facade facade = new Facade();
        List<Flight> flights = facade.getFlightByOrigin(FROM, DATE, TICKETS);
        String jsonFlight = gson.toJson(flights);
        return jsonFlight;
    }

    @GET
    @Path("{from}/{to}/{date}/{tickets}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFlightFromTo(@PathParam("from") String FROM, @PathParam("to") String TO, @PathParam("date") String DATE,
            @PathParam("tickets") int TICKETS) {
        Facade facade = new Facade();
        List<Flight> flights = facade.getFlight(FROM, TO, DATE, TICKETS);
        String flight = gson.toJson(flights);
        return flight;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/todo/{from}/{to}/{date}/{persons}")
    public String getFlights(@PathParam("from") String FROM, @PathParam("to") String TO,
            @PathParam("date") String DATE, @PathParam("persons") String PERSONS) {
        String json = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet GetRequest = new HttpGet("http://airline-plaul.rhcloud.com/api/flightinfo/" + FROM + "/" + TO + "/" + DATE + "/" + PERSONS);

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
}
