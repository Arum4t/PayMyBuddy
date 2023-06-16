package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Transaction;

import java.security.Principal;
import java.util.List;

public interface ITransactionService {
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(Integer id);
    List<Transaction> getTransactionByWalletId(Integer id_wallet);
    void sendMoneyToConnection (String contactEmail, String userEmail, Float amount,String description);
}
