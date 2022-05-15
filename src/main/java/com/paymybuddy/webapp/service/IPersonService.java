package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Person;

import java.util.List;

public interface IPersonService {
    Person savePerson(Person person);
    List<Person> getAllPersons();
    Person getPersonById(Integer id);
    Person updatePerson(Person person, Integer id);
    void deletePerson(Integer id);
}
