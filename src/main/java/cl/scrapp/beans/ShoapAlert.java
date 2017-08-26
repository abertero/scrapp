package cl.scrapp.beans;

import cl.scrapp.ScrappUtils;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by aldo on 26-08-17.
 */
public class ShoapAlert implements Serializable {
    private String continentalDate;
    private String georeference;
    private String postDate;
    private String status;
    private String postUrl;

    public ShoapAlert(Map<String, String> result) {
        this.continentalDate = ScrappUtils.getValueFromMap(result, 0);
        this.georeference = ScrappUtils.getValueFromMap(result, 1);
        this.postDate = ScrappUtils.getValueFromMap(result, 2);
        this.status = ScrappUtils.getValueFromMap(result, 3);
        this.postUrl = ScrappUtils.getValueFromMap(result, 4);
    }

    public String getContinentalDate() {
        return continentalDate;
    }

    public void setContinentalDate(String continentalDate) {
        this.continentalDate = continentalDate;
    }

    public String getGeoreference() {
        return georeference;
    }

    public void setGeoreference(String georeference) {
        this.georeference = georeference;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }
}
