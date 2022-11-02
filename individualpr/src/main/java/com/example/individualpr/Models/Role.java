package com.example.individualpr.Models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, SALESDEPARTMENTEMPLOYEE, EMPLOYEE;

    @Override
    public String getAuthority(){
        return name();
    }
}
