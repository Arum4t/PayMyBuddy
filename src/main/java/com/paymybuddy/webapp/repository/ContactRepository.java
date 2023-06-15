package com.paymybuddy.webapp.repository;


import com.paymybuddy.webapp.model.Contact;
import com.paymybuddy.webapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.List;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("SELECT c FROM Contact c WHERE c.person.idPerson = ?1")
    List<Contact> getAllContactFromUser(Integer personId);
}
