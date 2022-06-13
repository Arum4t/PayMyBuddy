package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Contact;
import org.apache.maven.artifact.repository.Authentication;


import java.security.Principal;
import java.util.List;

public interface IContactService {
    /*Contact saveFriend(Contact contact);
    List<Contact> getAllContact();
    Contact getContactById(Integer id);
    Contact updateContact(Contact contact, Integer id);
    void deleteContact(Integer id);*/
    void addContact(String contactEmail, Principal principal);
}
