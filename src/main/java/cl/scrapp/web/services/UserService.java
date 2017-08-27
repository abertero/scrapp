package cl.scrapp.web.services;

import cl.scrapp.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void saveUser(User user) {
        user.save();
    }

    public boolean validate(String userId, String password) {
        return User.validate(userId, password);
    }
}
