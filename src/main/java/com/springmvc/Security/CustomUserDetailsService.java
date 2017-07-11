package com.springmvc.Security;

import com.springmvc.model.UserProfile;
import com.springmvc.model.User;
import com.springmvc.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class);

    @Autowired
    UserService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String sso) throws UsernameNotFoundException {
        User user = userService.findBySSO(sso);
        logger.info("User = " + user);
        if(user==null){
            throw new UsernameNotFoundException("User isn't found");
        }
        return new org.springframework.security.core.userdetails.User(user.getSsoId(),
                                                                      user.getPassword(),
                                                              true, true, true, true,
                                                                      getGrantedAuthorities(user));
    }
    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(UserProfile userProfile : user.getUserProfiles()){
            logger.info("UserProfile = " + userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+ userProfile.getType()));
        }
        logger.info("authorities = " +authorities);
        return authorities;
    }
}
