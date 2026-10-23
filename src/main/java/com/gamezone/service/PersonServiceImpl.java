package com.gamezone.service;

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
    }
}