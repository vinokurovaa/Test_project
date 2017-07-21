package com.springmvc.dao;


import com.springmvc.model.UserForValidWithAnnotation;

public interface UserTestDaoForAnnotation {
    UserForValidWithAnnotation findByEmail(String email);
}
