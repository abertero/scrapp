package cl.scrapp;

import org.codehaus.jackson.JsonNode;

public class ScrappUtils {

    public static String getStringFromNode(JsonNode node, String property) {
        return node.get(property) != null ? node.get(property).asText() : "";
    }
}
