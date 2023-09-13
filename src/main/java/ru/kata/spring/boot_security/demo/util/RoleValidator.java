package ru.kata.spring.boot_security.demo.util;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

@Component
public class RoleValidator {

    public void addRole(User user, String selectedRole) {
        boolean validate = validate(user, selectedRole);
        System.out.println(validate);
        if (!validate) {
            Role role = new Role(selectedRole);
            role.setUser(user);
            user.getRole().add(role);
        }
    }

    private boolean validate(User user, String checkingRole) {
        return user.getRole().stream()
                .map(Role::getName)
                .anyMatch(roleName -> roleName.equalsIgnoreCase(checkingRole));
    }
}
