package cl.scrapp.web.services;

import cl.scrapp.beans.ShoapAlert;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class ShoapService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShoapService.class);

    public List<ShoapAlert> getInfo() {
        List<ShoapAlert> shoapAlerts = new ArrayList<>();
        try {
            Document page = Jsoup.connect("http://www.snamchile.cl").get();
            Elements alerts = page.select("div.scrollit tbody tr");
            Iterator<Element> rowIterator = alerts.iterator();
            while (rowIterator.hasNext()) {
                Element rowValue = rowIterator.next();
                Elements cells = rowValue.select("td");
                Iterator<Element> cellIterator = cells.iterator();
                int i = 0;
                Map<String, String> result = new HashMap<>();
                while (cellIterator.hasNext()) {
                    Element cellValue = cellIterator.next();
                    result.put(String.format("value-%s", i), cellValue.html());
                    ++i;
                }
                shoapAlerts.add(new ShoapAlert(result));
            }
        } catch (IOException e) {
            LOGGER.error("Problem loading page", e);
        }
        return shoapAlerts;
    }
}
