package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    public void getPersonByEmail() {
        Person person = mock(Person.class);
        when(personRepository.findByEmail("testeur@test.com")).thenReturn(person);

        Person personTest = personService.getPersonByEmail("testeur@test.com");

        Assertions.assertEquals(person,personTest);
        verify(personRepository, times(1)).findByEmail("testeur@test.com");
        verifyNoMoreInteractions(personRepository);
    }
    @Test
    void checkIfUserExist() {
        Boolean userExist = personService.checkIfUserExist("testeur@test.com");
        Assertions.assertNotNull(userExist);
    }

    @Test
    void getPersonIdByEmail() {
        Person person = mock(Person.class);
        when(personRepository.findByEmail("testeur@test.com")).thenReturn(person);

        Integer personId = personService.getPersonIdByEmail("testeur@test.com");

        Assertions.assertEquals(personId, person.getIdPerson());
    }
}