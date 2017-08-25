package cl.scrapp.web.controllers;

import cl.scrapp.beans.Alert;
import cl.scrapp.web.services.OnemiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private OnemiService onemiService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView main(@RequestParam(value = "_f", required = false, defaultValue = "false") Boolean first) {
        LOGGER.debug("Called main controller");
        ModelAndView mv = new ModelAndView("main");
        mv.addObject("first", first);
        return mv;
    }

    @RequestMapping(value = "/banner", method = RequestMethod.GET)
    @ResponseBody
    public List<Alert> onemiBanner() {
        LOGGER.debug("Called banner controller");
        return onemiService.getAlerts();
    }
}
