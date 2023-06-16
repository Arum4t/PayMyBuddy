package com.paymybuddy.webapp.repository;

import com.paymybuddy.webapp.model.Contact;
import com.paymybuddy.webapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t FROM Transaction t WHERE t.walletEmitter.idWallet = ?1")
    List<Transaction> getTransactionMadeByWalletId (Integer walletId);

    @Query("SELECT t FROM Transaction t WHERE t.walletReceiver.idWallet = ?1")
    List<Transaction> getTransactionReceivedByWalletId (Integer walletId);
}
