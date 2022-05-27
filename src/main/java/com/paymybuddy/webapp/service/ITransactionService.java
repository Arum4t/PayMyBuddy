package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Transaction;

import java.util.List;

public interface ITransactionService {
    Transaction saveTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(Integer id);
    Transaction updateTransaction(Transaction transaction, Integer id);
    void deleteTransaction(Integer id);
}
