package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.PersonValidateService;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {

    private final PersonValidateService personValidateService;

    @Autowired
    public PersonValidator(PersonValidateService personValidateService) {
        this.personValidateService = personValidateService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User checkedPerson = (User) target;
        Optional<User> foundPerson = personValidateService.loadPersonFromDataBase(checkedPerson.getUsername());

        if (foundPerson.isPresent()) {
            errors.rejectValue("username", "", "User already exists");
        }

    }
}
