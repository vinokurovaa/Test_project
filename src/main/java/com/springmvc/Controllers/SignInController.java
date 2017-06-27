package com.springmvc.Controllers;

import com.springmvc.model.Role;
import com.springmvc.model.User;
import com.springmvc.services.RoleService;
import com.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@SessionAttributes("roles")
public class SignInController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @RequestMapping(value = {"/signIn"}, method = RequestMethod.GET)
    public ModelAndView startSignIn(Locale locale, Map<String, Object> mapModel){
        Boolean flag = isCurrentAuthenticationAnonymous();
        User user = new User();
        mapModel.put("user", user);
        return new ModelAndView("signUp", mapModel);
    }
    @RequestMapping(value = {"/signIn"}, method = RequestMethod.POST, params = {"email", "password"})
    public ModelAndView signIn(@ModelAttribute("user")User user, Locale locale, BindingResult bindingResult) {
        Boolean flag = isCurrentAuthenticationAnonymous();
        User returnUser = userService.findUserByEmail(user.getEmail());
        if (returnUser != null) {
            if (user.getPassword().equals(returnUser.getPassword())) {
                return new ModelAndView("test1");
            } else return new ModelAndView("login");
        } else {
             return new ModelAndView("login");
        }
    }
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
    @ModelAttribute("roles")
    public List<Role> initializeProfiles() {
        return roleService.findAll();
    }
}
