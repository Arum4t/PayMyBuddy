package com.paymybuddy.webapp.service;


import com.paymybuddy.webapp.model.Contact;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.repository.ContactRepository;
import com.paymybuddy.webapp.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;


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

    public void addContact(String contactEmail, Principal principal){
        Integer contactId = personRepository.findIdByEmail(contactEmail);
        Person person = personRepository.findByEmail(principal.getName());
        Integer personId = person.getIdPerson();
        if (!contactEmail.equals(principal.getName())) {
            logger.info("add contact successful");

            Contact contact = new Contact();
            Person currentPerson = new Person();
            Person personContact = new Person();

            personContact.setIdPerson(contactId);
            currentPerson.setIdPerson(personId);
            contact.setContact(personContact);
            contact.setPerson(currentPerson);

            contactRepository.save(contact);
        }
        logger.info("add contact failed");
    }
}