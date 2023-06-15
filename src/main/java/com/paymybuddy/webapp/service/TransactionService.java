package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.ResourceNotFoundException;
import com.paymybuddy.webapp.model.Contact;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Transaction;
import com.paymybuddy.webapp.model.Wallet;
import com.paymybuddy.webapp.model.specific.TransactionData;
import com.paymybuddy.webapp.repository.PersonRepository;
import com.paymybuddy.webapp.repository.TransactionRepository;
import com.paymybuddy.webapp.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    private final Logger logger = LoggerFactory.getLogger(ContactService.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private WalletRepository walletRepository;

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
       // return transactionRepository.findByWalletId(id_wallet);
        return null;
    }

    @Override
    public void sendMoneyToConnection(String contactEmail, Float amount, Principal principal) {
        Person personUser = personRepository.findByEmail(principal.getName());
        Person personToAdd = personRepository.findByEmail(contactEmail);
        Integer personId = personUser.getIdPerson();
        Integer contactId = personToAdd.getIdPerson();

        WalletService walletService = new WalletService();
        Wallet userWallet = walletService.getWalletByPersonId(personId);
        Wallet contactWallet = walletService.getWalletByPersonId(contactId);

        if(amount > 0){
            Transaction newTransaction = new Transaction();
            userWallet.setAmount(walletService.removeMoneyToWallet(userWallet.getIdWallet(),amount));
            contactWallet.setAmount(walletService.addMoneyToWallet(contactWallet.getIdWallet(),amount));
            newTransaction.setAmount(amount);
            newTransaction.setWalletEmitter(userWallet);
            newTransaction.setWalletReceiver(contactWallet);
            newTransaction.setDescription("new transaction");

            transactionRepository.save(newTransaction);
            logger.info("Money send to connection with success");
        }
        logger.info("Amount need to be above O");
    }

    // userTransactionDone
    public List<Transaction> userTransaction(Integer walletId){
        return transactionRepository.getTransactionByWalletId(walletId);
    }

    //userTransactionReceive
}
