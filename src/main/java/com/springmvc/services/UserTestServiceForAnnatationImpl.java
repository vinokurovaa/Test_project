package com.springmvc.services;

import com.springmvc.dao.UserTestDaoForAnnotation;
import com.springmvc.model.UserForValidWithAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserTestServiceForAnnatation")
@Transactional
public class UserTestServiceForAnnatationImpl implements UserTestServiceForAnnatation {

    @Autowired
    UserTestDaoForAnnotation userDao;

    public UserForValidWithAnnotation findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
