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
    public void sendMoneyToConnection(String contactEmail, String userEmail, Float amount, String description) {
        Person personUser = personRepository.findByEmail(userEmail);
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
            newTransaction.setDescription(description);

            transactionRepository.save(newTransaction);
            logger.info("Money send to connection with success");
        }
        logger.info("Amount need to be above O");
    }

    public List<TransactionData> userTransactionMade(Integer walletId){
        List<TransactionData> transactionMade = new ArrayList<>();

        List<Transaction> transactions = transactionRepository.getTransactionMadeByWalletId(walletId);

        for(Transaction transaction : transactions){
            TransactionData oneTransaction = new TransactionData();
            oneTransaction.setDescription(transaction.getDescription());
            oneTransaction.setAmount(transaction.getAmount());
            oneTransaction.setReceiverEmail(transaction.getWalletReceiver().getIdPerson().getEmail());
            transactionMade.add(oneTransaction);
        }
        return transactionMade;
    }
    public List<TransactionData> userTransactionReceived(Integer walletId){
        List<TransactionData> transactionReceived = new ArrayList<>();

        List<Transaction> transactions = transactionRepository.getTransactionReceivedByWalletId(walletId);

        for(Transaction transaction : transactions){
            TransactionData oneTransaction = new TransactionData();
            oneTransaction.setDescription(transaction.getDescription());
            oneTransaction.setAmount(transaction.getAmount());
            oneTransaction.setReceiverEmail(transaction.getWalletEmitter().getIdPerson().getEmail());
            transactionReceived.add(oneTransaction);
        }
        return transactionReceived;
    }
}
