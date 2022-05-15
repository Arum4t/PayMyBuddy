package com.paymybuddy.webapp.repository;

import com.paymybuddy.webapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    // query exemple
    // @Query("select id_person from person...")
}
