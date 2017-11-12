package cl.scrapp.utils;

import cl.scrapp.model.Contact;
import cl.scrapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtils.class);

    public static boolean sendMail(User user, Contact contact) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("correo@correo.cl", "contraseña");
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("noreply@ohscr-app.cl"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(contact.getEmail()));
            message.setSubject("[OHSCR-APP] Alerta de notificación");
            message.setText("Estimado " + contact.getName() + ":" +
                    "\n\n El usuario " + user.getFullName() + " lo está alertando de una emergencia. " +
                    "Por favor contactarse con él por cualquier medio.");

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            LOGGER.error("Error enviando correo", e);
            return false;
        }
    }
}
