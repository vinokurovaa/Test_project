package com.springmvc.Controllers;

import com.springmvc.model.TestUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = {"/validForm"})
public class SingUpControllerWithJquery {

    @RequestMapping(method = RequestMethod.GET)
    public String singup(ModelMap model, Locale locale){
        TestUser user = new TestUser();
        model.put("userForm", user);
        return "SingUpWithValidationJQuery";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm")TestUser user, BindingResult result, Locale locale){
        return "success";
    }
}
