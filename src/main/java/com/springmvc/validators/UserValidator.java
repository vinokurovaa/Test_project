package com.springmvc.validators;


import com.springmvc.model.TestUser;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by anvi0616 on 7/13/2017.
 */
@Component
public class UserValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return TestUser.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        TestUser user = (TestUser) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.empty", "Email must not be empty");
        String email = user.getEmail();
        if(!email.contains("@")){
            errors.rejectValue("email", "email.incorrect", "Email is not correct");
        }

    }
}
