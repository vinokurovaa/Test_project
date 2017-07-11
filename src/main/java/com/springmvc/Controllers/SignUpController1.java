package com.springmvc.Controllers;

import com.springmvc.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class SignUpController1 {
/*
    @RequestMapping(value = { "/registuser"}, method = RequestMethod.GET)
    public ModelAndView newuser(Locale locale, ModelMap modelMap){
        User user = new User();
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("loggedinuser", getPrincipal());
        return new ModelAndView("myModal");
    }

    @RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
    public ModelAndView saveuser(@Valid User user, BindingResult result,
                                 ModelMap model){

        return new ModelAndView("myModal");

    }
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }*/
}
