package com.paymybuddy.webapp.repository;

import com.paymybuddy.webapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // query exemple
    // @Query("select id_person from person...")

    Person findByEmail(String email);

    boolean existsByEmail(String email);
}
