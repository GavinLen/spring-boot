package xyz.ieden.wt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lianghongwei01
 * @date 2019/1/22 16:51
 */
@Controller
@RequestMapping(value = "select")
public class SelectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelectController.class);

    @GetMapping(value = "index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("select/select_demo");
        return modelAndView;
    }

}
