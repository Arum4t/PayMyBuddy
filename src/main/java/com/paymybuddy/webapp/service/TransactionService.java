package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.ResourceNotFoundException;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Transaction;
import com.paymybuddy.webapp.repository.PersonRepository;
import com.paymybuddy.webapp.repository.TransactionRepository;
import com.paymybuddy.webapp.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    private final Logger log = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PersonRepository personRepository;

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
    public List<Transaction> getTransactionByWalletId(Integer id_wallet) {
//        return transactionRepository.findByWalletId(id_wallet);
        return null;
    }

    @Override
    public Transaction updateTransaction(Transaction transaction, Integer id) {
        Transaction existingTransaction = transactionRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Transaction", "Id", id));
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setDescription(transaction.getDescription());
        transactionRepository.save(existingTransaction);
        return existingTransaction;
    }

    @Override
    public void deleteTransaction(Integer id) {
        transactionRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Transaction", "Id", id));
        transactionRepository.deleteById(id);
    }

//    public Person transferMoneyToFriend (Principal principal){
//        Person person = personRepository.findByEmail(principal.getName());
//
//    }
}
