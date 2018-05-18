package xyz.ieden.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ThinkPad
 * @date Created by 2018/5/18 11:19
 */
@Controller
@RequestMapping(value = "home")
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @GetMapping(value = "")
    public ModelAndView toHome() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
}
