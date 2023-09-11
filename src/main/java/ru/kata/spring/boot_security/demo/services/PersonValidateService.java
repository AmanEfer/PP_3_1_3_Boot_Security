package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PersonValidateService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonValidateService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<User> loadPersonFromDataBase(String username) {
        return peopleRepository.findByUsername(username);
    }
}
