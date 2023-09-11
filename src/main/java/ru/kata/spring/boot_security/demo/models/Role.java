package ru.kata.spring.boot_security.demo.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String name;

    Role(String name) {
        this.name = name;
    }


    @Override
    public String getAuthority() {
        return name;
    }
}
