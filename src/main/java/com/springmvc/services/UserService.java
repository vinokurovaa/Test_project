package com.springmvc.services;

import com.springmvc.model.User;

import java.util.List;

/**
 * Created by Asus on 14.06.2017.
 */
public interface UserService {
    User findById(int id);
    User findBySSO(String sso);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserBySSO(String sso);
    List<User> findAllUsers();
    boolean isUserSSOUnique(Integer id, String sso);
}
