package com.paymybuddy.webapp.repository;

import com.paymybuddy.webapp.model.Friend;
import com.paymybuddy.webapp.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Integer> {
}
