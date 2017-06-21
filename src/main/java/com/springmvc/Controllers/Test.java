package com.springmvc.Controllers;

import com.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;
import java.util.Map;

@Controller
public class Test {
    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public ModelAndView regis(Locale locale, Map<String, Object> mv) {
        User user = new User();
        mv.put("newUser", user);
        return new ModelAndView("test", mv);
    }

    @RequestMapping(value = {"/test"}, method = RequestMethod.POST, params = {"email","firstName", "lastName"})
    public ModelAndView setPassword(@ModelAttribute("newUser") User newUser, Locale locate, BindingResult bindingResult) {
        return new ModelAndView("test1");
    }
}