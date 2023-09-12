package ru.kata.spring.boot_security.demo.models;

public class RoleWrapper {
    private Role role;

    public RoleWrapper() {

    }

    public RoleWrapper(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
