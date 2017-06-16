package com.springmvc.services;

import com.springmvc.model.Role;

import java.util.List;


public interface RoleService {
    Role findById(int id);
    Role findByRole(String role);
    List<Role> findAll();
}
