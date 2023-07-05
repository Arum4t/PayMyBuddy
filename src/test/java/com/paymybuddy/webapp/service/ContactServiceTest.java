package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.NoUserFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
class ContactServiceTest {

    @Mock
    private ContactService contactService;
    @Test
    void addConnection() throws NoUserFoundException {
        contactService.addConnection("tim@test.com", "olivier@test.com");
        verify(contactService).addConnection("tim@test.com", "olivier@test.com");
    }
    @Test
    void userContact() {
        contactService.userContact(1);
        verify(contactService).userContact(1);
    }
}