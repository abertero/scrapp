package cl.scrapp.web.controllers;

import cl.scrapp.beans.OnemiAlert;
import cl.scrapp.beans.ShoaAlert;
import cl.scrapp.model.Info;
import cl.scrapp.model.User;
import cl.scrapp.utils.ScrappUtils;
import cl.scrapp.utils.SessionUtils;
import cl.scrapp.web.services.InfoService;
import cl.scrapp.web.services.OnemiService;
import cl.scrapp.web.services.ShoaService;
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
@RequestMapping("/main")
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private OnemiService onemiService;
    @Autowired
    private ShoaService shoaService;
    @Autowired
    private InfoService infoService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView main(@RequestParam(value = "_f", required = false, defaultValue = "false") Boolean first) {
        LOGGER.debug("Called main controller");
        ModelAndView mv = new ModelAndView("main");
        mv.addObject("first", first);
        mv.addObject("MAPS_API_KEY", ScrappUtils.MAPS_API_KEY);
        mv.addObject("user", SessionUtils.getUser(request, ScrappUtils.SESSION_USERNAME));
        return mv;
    }

    @RequestMapping(value = "onemi", method = RequestMethod.GET)
    @ResponseBody
    public List<OnemiAlert> onemiInfo() {
        LOGGER.debug("Called onemi controller");
        return onemiService.getAlerts();
    }

    @RequestMapping(value = "shoa", method = RequestMethod.GET)
    @ResponseBody
    public List<ShoaAlert> shoaInfo() {
        LOGGER.debug("Called shoa controller");
        return shoaService.getInfo();
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    @ResponseBody
    public List<Info> info() {
        LOGGER.debug("Called info controller");
        return infoService.getLastMonth();
    }

    @RequestMapping(value = "addInfo", method = RequestMethod.POST)
    @Transactional
    public ModelAndView addInfo(@ModelAttribute Info info) {
        LOGGER.debug(String.format("Called addInfo controller %s", info));
        User user = SessionUtils.getUser(request, ScrappUtils.SESSION_USERNAME);
        infoService.saveInfo(info, user);
        return new ModelAndView("redirect:/main");
    }
}
