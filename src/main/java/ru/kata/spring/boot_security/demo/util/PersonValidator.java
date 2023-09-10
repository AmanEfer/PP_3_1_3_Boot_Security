package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kata.spring.boot_security.demo.models.Person;
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
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person checkedPerson = (Person) target;
        Optional<Person> foundPerson = personValidateService.loadPersonFromDataBase(checkedPerson.getUsername());

        if (foundPerson.isPresent()) {
            errors.rejectValue("username", "", "User already exists");
        }

    }
}
