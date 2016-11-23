/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.exampo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author Orvur
 */
public class NewClass {

    public static void main(String[] args) {

//        try {
//            URL url = new URL("http://airline-plaul.rhcloud.com");
//            String query = "api/flightinfo/SXF/2017-01-01T00:00:00.000Z/1";
//
//            //make connection
//            URLConnection urlc = url.openConnection();
//
//            //use post mode
//            urlc.setDoOutput(true);
//            urlc.setAllowUserInteraction(false);
//
//            //send query
//            PrintStream ps = new PrintStream(urlc.getOutputStream());
//            ps.print(query);
//            ps.close();
//
//            //get result
//            BufferedReader br = new BufferedReader(new InputStreamReader(urlc
//                    .getInputStream()));
//            String l = null;
//            while ((l = br.readLine()) != null) {
//                System.out.println(l);
//            }
//            br.close();
//        } catch (IOException ex) {
//            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet GetRequest = new HttpGet("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-01T00:00:00.000Z/1");

            //StringEntity input = new StringEntity("{\"qty\":100,\"name\":\"iPad 4\"}");
            //input.setContentType("application/json");
            //postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(GetRequest);

//            if (response.getStatusLine().getStatusCode() != 201) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + response.getStatusLine().getStatusCode());
//            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
