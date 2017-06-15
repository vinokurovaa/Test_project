package com.springmvc.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Asus on 14.06.2017.
 */
@Entity
@Table(name = "ROLES")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ROLE", unique = true, nullable = false, length = 15)
    private String role = UserRoleType.USER.getUserRoleType();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
