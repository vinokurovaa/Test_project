package com.springmvc.Controllers;


import com.springmvc.model.UserForValidWithAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping(value = "validAnnotation")
public class UserValidateAnnotationController {
    @RequestMapping(method = RequestMethod.GET)
    public String loadFormPage(Model model, Locale locale){
        UserForValidWithAnnotation user = new UserForValidWithAnnotation();
        model.addAttribute("userForValidWithAnnotation", user);
        return "AnnotationValidEmail";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@Valid UserForValidWithAnnotation user, BindingResult result, Model m, Locale locale){
        if(result.hasErrors()){
            return "AnnotationValidEmail";
        }
        return "success";
    }
}
