package com.springmvc.services;

import com.springmvc.model.User;

import java.util.List;


public interface UserService {
    User findById(int id);
    User findBySSO(String sso);
    User findUserByEmail(String email);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserBySSO(String sso);
    List<User> findAllUsers();
    boolean isUserSSOUnique(Integer id, String sso);
    boolean isUserEmailUnique(String email);

}
