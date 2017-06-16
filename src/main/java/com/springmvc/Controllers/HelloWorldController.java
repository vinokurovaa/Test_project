package com.springmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class HelloWorldController {
   /* @RequestMapping(value={ "/hello"}, method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring!");
        return "hello";
    }*/
    @RequestMapping(value={ "/hello"}, method = RequestMethod.GET)
    public ModelAndView user(Locale locale){
        return new ModelAndView("hello");
    }
}
