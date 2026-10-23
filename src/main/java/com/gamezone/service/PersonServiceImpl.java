package com.gamezone.service;

feature/exception-handling
import com.gamezone.model.Person;
import com.gamezone.repository.PersonRepositoryImpl;
import java.util.List;

public class PersonServiceImpl {
    private final PersonRepositoryImpl personRepository;
    private final List<Person> persons;

    public PersonServiceImpl() {
        this.personRepository = new PersonRepositoryImpl();
        this.persons = personRepository.loadAll();
    }

    public void registerPerson(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Los datos de la persona no pueden ser nulos");
        }
        persons.add(person);
        personRepository.saveAll(persons);
    }

    public Person findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El identificador proporcionado no es válido");
        }
        return persons.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("La persona con identificador " + id + " no fue encontrada"));
    }

    public List<Person> getAllPersons() {
        return persons;

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
develop
    }
}