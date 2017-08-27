package cl.scrapp.web.controllers;

import cl.scrapp.model.User;
import cl.scrapp.web.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login() {
        LOGGER.debug("Called login controller");
        return new ModelAndView("login");
    }

    @RequestMapping(value = "log", method = RequestMethod.POST)
    public ModelAndView log(@RequestParam String userId, @RequestParam String password) {
        LOGGER.debug("Called log controller");
        return new ModelAndView("redirect:/main?_f=true");
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register() {
        LOGGER.debug("Called register controller");
        return new ModelAndView("register");
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @Transactional
    public ModelAndView create(@ModelAttribute User user) {
        LOGGER.debug(String.format("Called create controller %s", user));
        userService.saveUser(user);
        return new ModelAndView("redirect:/main?_f=true");
    }
}
