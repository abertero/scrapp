package cl.scrapp.model;

import cl.scrapp.model.base.BaseEntity;
import cl.scrapp.web.config.JPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class User extends BaseEntity {
    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);

    private String name;
    private String lastName;
    private String password;
    private String userId;
    @Temporal(TemporalType.DATE)
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFullName() {
        return String.format("%s %s", name, lastName);
    }

    public boolean save() {
        try {
            JPA.em().persist(this);
            LOGGER.info("Modified user " + toString());
            return true;
        } catch (Exception e) {
            LOGGER.error("Exception modifying user", e);
        }
        return false;
    }

    public static boolean validate(String userId, String password) {
        String query = "SELECT COUNT(u) FROM User u WHERE u.userId = ?1 AND u.password = ?2";
        Number count = JPA.querySingle(query, userId, password);
        return count != null && count.longValue() == 1;
    }

    public static User findByUserId(String userId) {
        return JPA.queryFirst("SELECT u FROM User u WHERE u.userId = ?1", userId);
    }
}
