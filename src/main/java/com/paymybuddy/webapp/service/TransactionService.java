package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.ResourceNotFoundException;
import com.paymybuddy.webapp.model.Transaction;
import com.paymybuddy.webapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Integer id) {
        return transactionRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Transaction", "Id", id));
    }

    @Override
    public Transaction updateTransaction(Transaction transaction, Integer id) {
        Transaction existingTransaction = transactionRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Transaction", "Id", id));
        existingTransaction.setAmount_transaction(transaction.getAmount_transaction());
        existingTransaction.setType(transaction.getType());
        transactionRepository.save(existingTransaction);
        return existingTransaction;
    }

    @Override
    public void deleteTransaction(Integer id) {
        transactionRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Transaction", "Id", id));
        transactionRepository.deleteById(id);
    }
}
