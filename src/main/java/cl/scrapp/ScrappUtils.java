package cl.scrapp;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;

import java.util.Map;

public class ScrappUtils {
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final String SESSION_USERNAME = "USERNAME";
    public static final String MAPS_API_KEY = "AIzaSyBibn8sUpgGxsLBi_DJns-eWMa6V2n_4g0";
    public static final int JPA_MAX_RESULTS = 15;

    public static String getStringFromNode(JsonNode node, String property) {
        return node.get(property) != null ? node.get(property).asText() : "";
    }

    public static String getWarningLevelFromColor(String color) {
        if (StringUtils.isNotBlank(color)) {
            switch (color) {
                case "amarillo":
                    return "warning";
                case "rojo":
                    return "danger";
                case "azul":
                    return "info";
                case "verde":
                    return "success";
            }
        }
        return "warning";
    }

    public static String getValueFromMap(Map<String, String> map, int position) {
        String result = map.get(String.format("value-%s", position)) != null ? map.get(String.format("value-%s", position)) : "";
        return StringUtils.replace(StringUtils.replace(StringUtils.replace(result, "<br>", ""), "</b>", ""), "<b>", "");
    }
}
