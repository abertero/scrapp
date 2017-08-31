package cl.scrapp.web.services;

import cl.scrapp.model.Info;
import cl.scrapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    public void saveInfo(Info info, User user) {
        info.setUser(user);
        info.save();
    }

    public List<Info> getLast100() {
        return Info.findLast100();
    }
}
