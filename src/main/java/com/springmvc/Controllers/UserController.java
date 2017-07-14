package com.springmvc.Controllers;

import com.springmvc.model.TestUser;
import com.springmvc.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


import java.util.Locale;

/**
 * Created by anvi0616 on 7/13/2017.
 */
@Controller
@RequestMapping("/valid")
public class UserController {
    @Autowired
    private UserValidator validator;

    @RequestMapping(method = RequestMethod.GET)
    public String testUser(ModelMap model, Locale locale){
        TestUser user = new TestUser();
        model.put("userForm", user);
        return "testValidate";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm")TestUser user, BindingResult result, Locale locale){
        validator.validate(user, result);
        if(result.hasErrors()){
            return "testValidate";
        }
        return "success";
    }



}
