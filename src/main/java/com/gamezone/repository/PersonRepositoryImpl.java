package com.gamezone.repository;

import com.gamezone.model.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements IPersonRepository {

    private final List<Person> personList;

    public PersonRepositoryImpl() {
        this.personList = new ArrayList<>();
    }

    @Override
    public void addPerson(Person person) {
        if (person != null && findById(person.getId()) == null) {
            personList.add(person);
        }
    }

    @Override
    public Person findById(String id) {
        for (Person p : personList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(personList);
    }

    @Override
    public boolean updatePerson(Person person) {
        if (person == null) {
            return false;
        }
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId().equals(person.getId())) {
                personList.set(i, person);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        Person found = findById(id);
        if (found != null) {
            return personList.remove(found);
        }
        return false;
    }
}