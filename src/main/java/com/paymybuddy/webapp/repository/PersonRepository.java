package com.paymybuddy.webapp.repository;

import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
