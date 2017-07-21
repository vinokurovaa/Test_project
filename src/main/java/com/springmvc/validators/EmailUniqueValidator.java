package com.springmvc.validators;


import com.springmvc.model.UserForValidWithAnnotation;
import com.springmvc.services.UserTestServiceForAnnatation;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {
    @Autowired
    UserTestServiceForAnnatation userService;

    public void initialize(EmailUnique email) {

    }

    public boolean isValid(String emailField, ConstraintValidatorContext context) {
        if(!org.springframework.util.StringUtils.isEmpty(emailField)){
            UserForValidWithAnnotation user = userService.findByEmail(emailField);
            if(user == null){
                return true;
            }else{
                return false;
            }
        }else return false;
    }
}
