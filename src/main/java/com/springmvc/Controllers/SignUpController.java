package com.springmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("roles")
public class SignUpController {
  /* @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    MailService mailService;

    @RequestMapping(value = {"/signUp"}, method = RequestMethod.GET)
    public ModelAndView regis(Locale locale, Map<String, Object> mv) {
        User user = new User();
        mv.put("newUser", user);
        mv.put("loggedinuser", getPrincipal());
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
        return new ModelAndView("registrationsuccess");
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
    }

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    } */
}