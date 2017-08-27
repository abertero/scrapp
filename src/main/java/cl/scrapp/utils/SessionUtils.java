package cl.scrapp.utils;

import cl.scrapp.model.User;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
    private static final Logger logger = LoggerFactory.getLogger(SessionUtils.class);

    public static void addProperty(HttpServletRequest request, String propertyKey, String propertyValue) {
        request.getSession().setAttribute(propertyKey, CryptoUtils.encript(propertyValue));
        logger.info("Added property to session " + propertyKey + " ==> " + propertyValue);
    }

    public static String getProperty(HttpServletRequest request, String propertyKey) {
        if (request.getSession().getAttribute(propertyKey) != null) {
            return CryptoUtils.decript((String) request.getSession().getAttribute(propertyKey));
        }
        return null;
    }

    public static User getUser(HttpServletRequest request, String propertyKey) {
        String userId = getProperty(request, propertyKey);
        return StringUtils.isNotBlank(userId) ? User.findByUserId(userId) : null;
    }

    public static void removeProperty(HttpServletRequest request, String propertyKey) {
        request.getSession().removeAttribute(propertyKey);
        logger.info("Removed property from session " + propertyKey);
    }
}
