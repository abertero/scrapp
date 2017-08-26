package cl.scrapp.web.services;

import cl.scrapp.beans.ShoaAlert;
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
public class ShoaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShoaService.class);

    public List<ShoaAlert> getInfo() {
        List<ShoaAlert> shoaAlerts = new ArrayList<>();
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
                shoaAlerts.add(new ShoaAlert(result));
            }
        } catch (IOException e) {
            LOGGER.error("Problem loading page", e);
        }
        return shoaAlerts;
    }
}
