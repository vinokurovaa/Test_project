package com.springmvc.converter;

import com.springmvc.model.UserProfile;
import com.springmvc.services.UserProfileService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToRoleServiceConverter implements Converter<Object, UserProfile>{

    static final Logger logger = Logger.getLogger(RoleToRoleServiceConverter.class);

    @Autowired
    UserProfileService userProfileService;

    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public UserProfile convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        UserProfile profile = userProfileService.findById(id);
        return profile;
    }

}