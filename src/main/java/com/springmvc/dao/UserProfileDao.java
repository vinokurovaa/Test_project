package com.springmvc.dao;

import com.springmvc.model.UserProfile;

import java.util.List;

public interface UserProfileDao {
    UserProfile findById(int id);
    UserProfile findByRole(String role);
    List<UserProfile> findAll();

}
