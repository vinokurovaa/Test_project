package com.springmvc.model;

import java.io.Serializable;

/**
 * Created by Asus on 14.06.2017.
 */
public enum UserRoleType implements Serializable {
    USER("USER"),
    ADMIN("ADMIN"),
    DBA("DBA");

    String userRoleType;

    private UserRoleType(String userRoleType){
        this.userRoleType = userRoleType;
    }
    public  String getUserRoleType(){
        return userRoleType;
    }
}
