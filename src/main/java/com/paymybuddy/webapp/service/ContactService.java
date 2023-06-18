package com.paymybuddy.webapp.service;


import com.paymybuddy.webapp.exception.NoUserFoundException;
import com.paymybuddy.webapp.model.Contact;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Transaction;
import com.paymybuddy.webapp.repository.ContactRepository;
import com.paymybuddy.webapp.repository.PersonRepository;
import org.checkerframework.checker.units.qual.C;
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
public class    ContactService implements IContactService {

    private final Logger logger = LoggerFactory.getLogger(ContactService.class);

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PersonRepository personRepository;

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
    @Override
    public List<String> userContact(Integer userId){
        List <Contact> userContacts = contactRepository.getAllContactFromUser(userId);
        List<String> emailContacts = new ArrayList<>();
        for(Contact contact : userContacts){
            emailContacts.add(contact.getContact().getEmail());
        }
        return emailContacts;
    }
}