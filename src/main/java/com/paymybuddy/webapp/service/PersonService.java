package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.ResourceNotFoundException;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Person", "Id", id));
    }
    @Override
    public Person updatePerson(Person person, Integer id) {
        // Check personId exist in DB or not
        Person existingPerson = personRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Person", "Id", id));
        existingPerson.setEmail(person.getEmail());
        existingPerson.setPassword(person.getPassword());
        // Save existing Person to DB
        personRepository.save(existingPerson);
        return existingPerson;
    }

    @Override
    public void deletePerson(Integer id) {
        //Check Person exist in DB or not
        personRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Person", "Id", id));
        personRepository.deleteById(id);
    }

}

