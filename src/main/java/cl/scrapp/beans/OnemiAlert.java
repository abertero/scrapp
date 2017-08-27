package cl.scrapp.beans;

import cl.scrapp.utils.ScrappUtils;
import org.codehaus.jackson.JsonNode;

import java.io.Serializable;

public class OnemiAlert implements Serializable {
    private Integer id;
    private String author;
    private String postDate;
    private String postDateGmt;
    private String title;
    private String name;
    private String status;
    private String type;
    private String mimeType;
    private String permalink;
    private String riskType;
    private String region;
    private String date;
    private String time;
    private Boolean active;
    private Boolean history;
    private String color;
    private String archAlert;
    private String sharetwitter;
    private String warningType;

    public OnemiAlert(JsonNode node) {
        this.id = node.get("ID").asInt();
        this.author = ScrappUtils.getStringFromNode(node, "post_author");
        this.postDate = ScrappUtils.getStringFromNode(node, "post_date");
        this.postDateGmt = ScrappUtils.getStringFromNode(node, "post_date_gmt");
        this.title = ScrappUtils.getStringFromNode(node, "post_title");
        this.name = ScrappUtils.getStringFromNode(node, "post_name");
        this.status = ScrappUtils.getStringFromNode(node, "post_status");
        this.type = ScrappUtils.getStringFromNode(node, "post_type");
        this.mimeType = ScrappUtils.getStringFromNode(node, "post_mime_type");
        this.permalink = String.format("http://www.onemi.cl%s", ScrappUtils.getStringFromNode(node, "permalink"));
        this.riskType = ScrappUtils.getStringFromNode(node, "tipo_de_riesgo");
        this.region = ScrappUtils.getStringFromNode(node, "regiones");
        this.date = ScrappUtils.getStringFromNode(node, "fecha");
        this.time = ScrappUtils.getStringFromNode(node, "hora");
        this.active = node.get("activar") != null && node.get("activar").asInt() == 1;
        this.history = node.get("historico") != null && node.get("historico").asInt() == 1;
        this.color = ScrappUtils.getStringFromNode(node, "color_alerta");
        this.archAlert = ScrappUtils.getStringFromNode(node, "archi_alerta");
        this.sharetwitter = ScrappUtils.getStringFromNode(node, "sharetwitter");
        this.warningType = ScrappUtils.getWarningLevelFromColor(this.color);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getPostDateGmt() {
        return postDateGmt;
    }

    public void setPostDateGmt(String postDateGmt) {
        this.postDateGmt = postDateGmt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getHistory() {
        return history;
    }

    public void setHistory(Boolean history) {
        this.history = history;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getArchAlert() {
        return archAlert;
    }

    public void setArchAlert(String archAlert) {
        this.archAlert = archAlert;
    }

    public String getSharetwitter() {
        return sharetwitter;
    }

    public void setSharetwitter(String sharetwitter) {
        this.sharetwitter = sharetwitter;
    }

    public String getWarningType() {
        return warningType;
    }

    public void setWarningType(String warningType) {
        this.warningType = warningType;
    }
}
