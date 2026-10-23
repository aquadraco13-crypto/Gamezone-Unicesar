package com.gamezone.service;

import com.gamezone.exception.ValidationException;
import com.gamezone.model.Person;
import com.gamezone.repository.IPersonRepository;
import java.util.List;

public class PersonServiceImpl implements IPersonService {

    private final IPersonRepository personRepository;

    public PersonServiceImpl(IPersonRepository personRepository) {
        if (personRepository == null) {
            throw new ValidationException("PersonRepository cannot be null.");
        }
        this.personRepository = personRepository;
    }

    @Override
    public void save(Person person) {
        if (person == null) {
            throw new ValidationException("Person data cannot be null.");
        }
        if (person.getId() == null || person.getId().trim().isEmpty()) {
            throw new ValidationException("Person ID cannot be empty.");
        }
        personRepository.addPerson(person); // antes: create(person)
    }

    @Override
    public Person findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new ValidationException("ID search parameter cannot be empty.");
        }
        return personRepository.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}