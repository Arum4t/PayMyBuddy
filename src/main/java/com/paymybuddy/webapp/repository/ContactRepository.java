package com.paymybuddy.webapp.repository;


import com.paymybuddy.webapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findByPersonIdAndContactId(Integer personId, Integer contactId);
}
