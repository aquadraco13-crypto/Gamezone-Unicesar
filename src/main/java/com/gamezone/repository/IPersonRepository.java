package com.gamezone.repository;

import com.gamezone.model.Person;
import java.util.List;

public interface IPersonRepository {

    void addPerson(Person person);

    Person findById(String id);

    List<Person> findAll();

    boolean updatePerson(Person person);

    boolean deleteById(String id);
}