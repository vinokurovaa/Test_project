package com.springmvc.services;

import com.springmvc.model.Role;

import java.util.List;

/**
 * Created by Asus on 14.06.2017.
 */
public interface RoleService {
    Role findById(int id);
    Role findByRole(String role);
    List<Role> findAll();
}
