package com.springmvc.Controllers;

import com.springmvc.model.Role;
import com.springmvc.model.User;
import com.springmvc.services.MailService;
import com.springmvc.services.RoleService;
import com.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@SessionAttributes("roles")
public class SignUpController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    MailService mailService;

    @RequestMapping(value = {"/signUp"}, method = RequestMethod.GET)
    public ModelAndView regis(Locale locale, Map<String, Object> mv) {
        User user = new User();
        mv.put("newUser", user);
        return new ModelAndView("signUp", mv);
    }

    @RequestMapping(value = {"/signUp"}, method = RequestMethod.POST, params = {"email","firstName", "lastName"})
    public ModelAndView setPassword(@ModelAttribute("newUser") User newUser, Locale locate, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("signUp");
        }
        if(userService.isUserEmailUnique(newUser.getEmail())){
            newUser.setSsoId(newUser.getEmail());
            userService.saveUser(newUser);
            mailService.sendEmail(newUser);
        }else {
            FieldError emailError = new FieldError("user", "email", "Email already exist. Please fill in different value");
            bindingResult.addError(emailError);
            return new ModelAndView("signUp");

        }
        return new ModelAndView("test1");
    }
    @ModelAttribute("roles")
    public List<Role> initializeProfiles() {
        return roleService.findAll();
    }
}