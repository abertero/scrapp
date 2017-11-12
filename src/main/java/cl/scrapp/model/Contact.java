package cl.scrapp.model;

import cl.scrapp.model.base.BaseEntity;
import cl.scrapp.web.config.JPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Contact extends BaseEntity {
    private static final Logger LOGGER = LoggerFactory.getLogger(Contact.class);

    private String name;
    private String email;
    private String phone;
    @ManyToOne
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean save() {
        try {
            JPA.em().persist(this);
            LOGGER.info("Modified contact " + toString());
            return true;
        } catch (Exception e) {
            LOGGER.error("Exception modifying contact", e);
        }
        return false;
    }

    public boolean delete() {
        try {
            JPA.em().remove(this);
            LOGGER.info("Delete contact " + toString());
            return true;
        } catch (Exception e) {
            LOGGER.error("Exception deleting contact", e);
        }
        return false;
    }

    public static List<Contact> findByUser(String userId) {
        String query = "SELECT c FROM Contact c WHERE c.user.userId = ?1 ORDER BY c.name";
        return JPA.query(query, userId);
    }

    public static Contact findById(String altKey) {
        return JPA.findByAltKey(Contact.class, altKey);
    }
}
