package com.springmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class Test {
    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public ModelAndView test(Locale locale){
        return new ModelAndView("test");
    }
}
