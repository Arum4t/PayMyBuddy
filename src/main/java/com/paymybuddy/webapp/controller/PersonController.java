package com.paymybuddy.webapp.controller;

import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    // Create
    @PostMapping("/persons/create")
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        return new ResponseEntity<Person>(personService.savePerson(person), HttpStatus.CREATED);
    }
    // Read All persons
    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }
    // Read person by id
    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById (@PathVariable("id") Integer id_person){
        return new ResponseEntity<Person>(personService.getPersonById(id_person), HttpStatus.OK);
    }
    // Update person
    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Integer id_person,@RequestBody Person person){
        return new ResponseEntity<Person>(personService.updatePerson(person, id_person), HttpStatus.OK);
    }
    // Delete person
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Integer id_person){
        //Delete Person from DB
        personService.deletePerson(id_person);
        return new ResponseEntity<String>("Person deleted successfully!.", HttpStatus.OK);
    }

}
