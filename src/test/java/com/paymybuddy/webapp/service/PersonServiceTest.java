package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;


@SpringBootTest
class PersonServiceTest {

    @Mock
    private PersonService personService;

    @Test
    void getPersonByEmail() {
        personService.getPersonByEmail("olivier@test.com");
        verify(personService).getPersonByEmail("olivier@test.com");
    }
    @Test
    void checkIfUserExist() {
        personService.checkIfUserExist("olivier@test.com");
        verify(personService).checkIfUserExist("olivier@test.com");

    }

    @Test
    void getPersonIdByEmail() {
        personService.getPersonIdByEmail("olivier@test.com");
        verify(personService).getPersonIdByEmail("olivier@test.com");
    }

    @Test
    void updateEmailUser() {
        personService.updateEmailUser("bert@test.com", 2);
        verify(personService).updateEmailUser("bert@test.com",2);
    }

    @Test
    void updatePasswordUser() {
        personService.updatePasswordUser("testo", 2);
        verify(personService).updatePasswordUser("testo",2);
    }
}