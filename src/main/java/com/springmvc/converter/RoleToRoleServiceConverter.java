package com.springmvc.converter;

import com.springmvc.model.Role;
import com.springmvc.services.RoleService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToRoleServiceConverter implements Converter<Object, Role>{

    static final Logger logger = Logger.getLogger(RoleToRoleServiceConverter.class);

    @Autowired
    RoleService roleService;

    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Role convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        Role profile = roleService.findById(id);
        return profile;
    }

}