package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.UsersRepository;
import ru.kata.spring.boot_security.demo.util.RoleValidator;

import javax.transaction.Transactional;

@Service
public class RegistrationService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleValidator roleValidator;

    @Autowired
    public RegistrationService(UsersRepository usersRepository, PasswordEncoder passwordEncoder, RoleValidator roleValidator) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleValidator = roleValidator;
    }

    @Transactional
    public void register(User user, String roleName) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        roleValidator.addRole(user, roleName);

        usersRepository.save(user);
    }
}
