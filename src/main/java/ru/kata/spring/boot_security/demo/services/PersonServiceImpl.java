package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.PeopleRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return peopleRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return peopleRepository.getById(id);
    }

    @Override
    @Transactional
    public void saveUser(User person) {
        peopleRepository.save(person);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User person) {
        person.setId(id);
        peopleRepository.save(person);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        peopleRepository.deleteById(id);
    }
}
