package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.ResourceNotFoundException;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.PersonData;
import com.paymybuddy.webapp.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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
    @Override
    public void register(PersonData personData) throws Exception {

        //Let's check if user already registered with us
        if(checkIfUserExist(personData.getEmail())){
            throw new Exception("User already exists for this email");
        }
        Person person = new Person();
        BeanUtils.copyProperties(personData, person);
        encodePassword(person, personData);
        personRepository.save(person);
    }


    @Override
    public boolean checkIfUserExist(String email) {
        return personRepository.findByEmail(email) != null;
    }

    private void encodePassword( Person person, PersonData user){
        person.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}

