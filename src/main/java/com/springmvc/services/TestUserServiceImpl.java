package com.springmvc.services;

import com.springmvc.dao.TestUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("testUserService")
@Transactional
public class TestUserServiceImpl implements TestUserService {
    @Autowired
    TestUserDao userDao;
    public boolean findByEmail(String email) {
        return userDao.findUserByEmail(email);
    }
}
