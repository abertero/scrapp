package cl.scrapp.model;

import cl.scrapp.model.base.BaseEntity;
import cl.scrapp.web.config.JPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Info extends BaseEntity {
    private static final Logger LOGGER = LoggerFactory.getLogger(Info.class);

    private String subject;
    private String detail;
    private String location;
    private Double latitude;
    private Double longitude;
    private String photo;
    @ManyToOne
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;
    @Transient
    private String recordDateString;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getRecordDateString() {
        if (recordDateString == null && recordDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            recordDateString = sdf.format(recordDate);
        }
        return recordDateString;
    }

    public void setRecordDateString(String recordDateString) {
        this.recordDateString = recordDateString;
    }

    public boolean save() {
        this.recordDate = new Date();
        try {
            JPA.em().persist(this);
            LOGGER.info("Modified info " + toString());
            return true;
        } catch (Exception e) {
            LOGGER.error("Exception modifying info", e);
        }
        return false;
    }

    public static List<Info> findByUser(String userId) {
        String query = "SELECT i FROM Info i WHERE i.user.userId = ?1 ORDER BY i.recordDate";
        return JPA.query(query, userId);
    }

    public static List<Info> findLast100() {
        String queryStr = "SELECT i FROM Info i ORDER BY i.recordDate";
        TypedQuery<Info> query = JPA.em().createQuery(queryStr, Info.class);
        query.setMaxResults(100);
        return query.getResultList();
    }
}
