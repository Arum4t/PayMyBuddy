package com.paymybuddy.webapp.service;


import com.paymybuddy.webapp.exception.NoUserFoundException;
import com.paymybuddy.webapp.model.Contact;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.repository.ContactRepository;
import com.paymybuddy.webapp.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@Transactional
public class ContactService implements IContactService {

    private final Logger logger = LoggerFactory.getLogger(ContactService.class);

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

/*
    @Override
    public Contact getContactById(Integer id) {
        return friendRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact", "Id", id));
    }

    @Override
    public Contact updateContact(Contact contact, Integer id) {
        //Check friend exist in DB or not
        Contact existingContact = contactRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Contact", "Id", id));
        existingContact.setEmail(contact.getEmail());
        // Save existing Friend to DB
        contactRepository.save(existingContact);
        return existingFriend;
    }

    @Override
    public void deleteContact(Integer id) {
        //Check friend exist in DB or not
        contactRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact", "Id", id));
        contactRepository.deleteById(id);
    }*/

    @Override
    public void addConnection(String contactEmail, Principal principal){
        Person personUser = personRepository.findByEmail(principal.getName());
        Person personToAdd = personRepository.findByEmail(contactEmail);

        Integer personId = personUser.getIdPerson();
        Integer contactId = personToAdd.getIdPerson();

        if(contactId == null){
            logger.info("Request add connection failed");
            throw new NoUserFoundException(contactEmail);
        }
        if(!Objects.equals(contactId, personId)){
            logger.info("add connection successful");

            Contact newContact = new Contact();
            newContact.setContact(personToAdd);
            newContact.setPerson(personUser);

            contactRepository.save(newContact);
        }
        logger.info("add connection failed");
    }
}