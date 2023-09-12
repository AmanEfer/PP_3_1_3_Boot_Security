package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(Long id);

    public void saveUser(User person);

    public void updateUser(Long id, User person);

    public void deleteUser(Long id);
}
