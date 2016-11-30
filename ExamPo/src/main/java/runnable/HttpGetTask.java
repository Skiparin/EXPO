/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.concurrent.Callable;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author Orvur
 */
public class HttpGetTask implements Callable {

    private String url;

    /**
     * Instantiates a new callable calculater.
     *
     * @param first the first
     * @param last the last
     * @param divisor the divisor
     */
    public HttpGetTask(String url) {
        this.url = url;
    }

    @Override
    public String call() throws Exception {

        String json = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet GetRequest = new HttpGet(url);

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
