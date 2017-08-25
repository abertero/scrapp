package cl.scrapp;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;

public class ScrappUtils {

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
}
