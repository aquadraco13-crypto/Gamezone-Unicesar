package com.gamezone.service;

import com.gamezone.model.Person;
import java.util.List;

public interface IPersonService {

    void save(Person person);

    Person findById(String id);

    List<Person> findAll();
}