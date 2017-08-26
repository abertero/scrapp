package cl.scrapp.web.services;

import cl.scrapp.beans.OnemiAlert;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OnemiService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OnemiService.class);
    private static final String URL_ONEMI_ALERTS = "http://www.onemi.cl/api/json/alertas/?_=1503631111005";

    public String getBanner() {
        try {
            Document page = Jsoup.connect("http://www.onemi.cl").get();
            // esto no funciona porque las cosas se cargan desde la api
            Elements alerts = page.select("section.alertas");
            return alerts.html();
        } catch (IOException e) {
            LOGGER.error("Problem loading page", e);
        }
        return null;
    }

    public List<OnemiAlert> getAlerts() {
        Client client = Client.create();
        WebResource webResource = client.resource(URL_ONEMI_ALERTS);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
        if (response.getStatus() != 200) {
            LOGGER.warn(String.format("Failed: HTTP error code %s during GET request %s", response.getStatus(), URL_ONEMI_ALERTS));
        }
        String entity = response.getEntity(String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<OnemiAlert> result = new ArrayList<>();
        try {
            JsonNode node = mapper.readTree(entity);
            Iterator<JsonNode> iterator = node.getElements();
            while (iterator.hasNext()) {
                JsonNode alertNode = iterator.next();
                result.add(new OnemiAlert(alertNode));
            }
        } catch (IOException e) {
            LOGGER.error("Error reading JSON", e);
        }
        return result;
    }
}
