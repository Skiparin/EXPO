/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnable;

import java.util.concurrent.Callable;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        return target.request(MediaType.APPLICATION_JSON).get(String.class);
    }
}
