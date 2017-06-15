package com.springmvc.dao;

import com.springmvc.model.Role;

import java.util.List;

public interface RoleDao {
    Role findById(int id);
    Role findByRole(String role);
    List<Role> findAll();

}
