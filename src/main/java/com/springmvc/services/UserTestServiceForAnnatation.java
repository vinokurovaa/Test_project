package com.springmvc.services;


import com.springmvc.model.UserForValidWithAnnotation;

public interface UserTestServiceForAnnatation {
    UserForValidWithAnnotation findByEmail(String email);
}
