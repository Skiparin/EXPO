/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
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

/**
 * REST Web Service
 *
 * @author Orvur
 */
@Path("/flight")
public class GenericResource {

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
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        //TODO return proper representation object
        return "hye";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/todo/{from}/{to}/{date}/{persons}")
    public String getFlights( @PathParam("from") String FROM, @PathParam("to") String TO,
                              @PathParam("date") String DATE, @PathParam("persons") String PERSONS) {
        String reply = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            String test = "http://airline-plaul.rhcloud.com/api/flightinfo/" + FROM + "/" + TO + "/" + DATE + "/" + PERSONS;
            System.out.println(test);
            HttpGet GetRequest = new HttpGet(test);
            

            HttpResponse response = httpClient.execute(GetRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            String json = "";
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                json = json.concat(output);
                System.out.println(json);
            }
            System.out.println(json);
            reply = json;
            httpClient.getConnectionManager().shutdown();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return reply;
    }
}
