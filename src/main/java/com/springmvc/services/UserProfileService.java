package com.springmvc.services;

import com.springmvc.model.UserProfile;

import java.util.List;


public interface UserProfileService {
    UserProfile findById(int id);
    UserProfile findByRole(String role);
    List<UserProfile> findAll();
}
