package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.specific.PersonData;

import java.util.List;

public interface IPersonService {
    Person getPersonByEmail(String email);
    void register(PersonData user) throws Exception;
    boolean checkIfUserExist(String email);
    void encodePassword( Person person, PersonData user);
    Integer getPersonIdByEmail(String email);
    void updateEmailUser(String email,Integer userId);
    void updatePasswordUser(String password, Integer userId);
}
