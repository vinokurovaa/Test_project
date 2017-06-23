package com.springmvc.Controllers;

import com.springmvc.model.User;
import com.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import java.util.Locale;
import java.util.Map;

@Controller
public class SignInController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/signIn"}, method = RequestMethod.GET)
    public ModelAndView startSignIn(Locale locale, Map<String, Object> mapModel){
        User user = new User();
        mapModel.put("user", user);
        return new ModelAndView("signUp", mapModel);
    }
    @RequestMapping(value = {"/signIn"}, method = RequestMethod.POST, params = {"email", "password"})
    public ModelAndView signIn(@ModelAttribute("user")User user, Locale locale, BindingResult bindingResult) {
        User returnUser = userService.findUserByEmail(user.getEmail());
        if (returnUser != null) {
            if (user.getPassword().equals(returnUser.getPassword())) {
                return new ModelAndView("test1");
            } else return new ModelAndView("login");
        } else {
             return new ModelAndView("login");
        }
    }
}
