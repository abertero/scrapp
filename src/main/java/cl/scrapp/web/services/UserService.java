package cl.scrapp.web.services;

import cl.scrapp.model.Contact;
import cl.scrapp.model.User;
import cl.scrapp.utils.EmailUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public void saveUser(User user) {
        user.save();
    }

    public boolean validate(String userId, String password) {
        return User.validate(userId, password);
    }

    public boolean alert(User user) {
        List<Contact> contacts = Contact.findByUser(user.getUserId());
        for (Contact contact : contacts) {
            if (!EmailUtils.sendMail(user, contact)) {
                return false;
            }
        }
        return true;
    }
}
