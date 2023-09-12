package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.UsersRepository;

import java.util.Optional;

@Service
public class UserValidateService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserValidateService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Optional<User> loadPersonFromDataBase(String username) {
        return usersRepository.findByUsername(username);
    }
}
