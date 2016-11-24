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
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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
    public String getFlights() {
        String reply = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet GetRequest = new HttpGet("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-01T00:00:00.000Z/1");

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
