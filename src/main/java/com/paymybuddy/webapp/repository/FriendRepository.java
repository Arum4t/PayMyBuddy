package com.paymybuddy.webapp.repository;

import com.paymybuddy.webapp.model.Friend;
import com.paymybuddy.webapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {
}
