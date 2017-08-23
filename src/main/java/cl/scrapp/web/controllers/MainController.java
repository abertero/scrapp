package cl.scrapp.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView main() {
        LOGGER.debug("Called main controller");
        return new ModelAndView("main");
    }
}
