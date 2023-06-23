package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.NoUserFoundException;


import java.security.Principal;
import java.util.List;

public interface IContactService {
    void addConnection(String contactEmail, Principal principal) throws NoUserFoundException;
    List<String> userContact(Integer userId);
}
