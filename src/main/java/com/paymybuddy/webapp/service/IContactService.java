package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.NoUserFoundException;
import com.paymybuddy.webapp.model.Contact;
import org.apache.maven.artifact.repository.Authentication;


import java.security.Principal;
import java.util.List;

public interface IContactService {
    void addConnection(String contactEmail, Principal principal) throws NoUserFoundException;
    List<String> userContact(Integer userId);
}
