package cl.scrapp.web.controllers;

import cl.scrapp.model.Contact;
import cl.scrapp.model.User;
import cl.scrapp.utils.ScrappUtils;
import cl.scrapp.utils.SessionUtils;
import cl.scrapp.web.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsController.class);
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getContacts() {
        LOGGER.debug(String.format("Called contacts controller"));
        User user = SessionUtils.getUser(request, ScrappUtils.SESSION_USERNAME);
        return Contact.findByUser(user.getUserId());
    }

    @RequestMapping(value = "addContact", method = RequestMethod.POST)
    @Transactional
    public ModelAndView addContact(@ModelAttribute Contact contact) {
        LOGGER.debug(String.format("Called addContact controller %s", contact));
        User user = SessionUtils.getUser(request, ScrappUtils.SESSION_USERNAME);
        contact.setUser(user);
        contact.save();
        return new ModelAndView("redirect:/main");
    }

    @RequestMapping(value = "delete/{altKey}", method = RequestMethod.GET)
    @Transactional
    public ModelAndView deleteContact(@PathVariable String altKey) {
        LOGGER.debug(String.format("Called deleteContact controller %s", altKey));
        Contact contact = Contact.findById(altKey);
        contact.delete();
        return new ModelAndView("redirect:/main");
    }

    @RequestMapping(value = "alert")
    @ResponseBody
    public Boolean alert() {
        LOGGER.debug(String.format("Called alert controller"));
        User user = SessionUtils.getUser(request, ScrappUtils.SESSION_USERNAME);
        return userService.alert(user);
    }
}
