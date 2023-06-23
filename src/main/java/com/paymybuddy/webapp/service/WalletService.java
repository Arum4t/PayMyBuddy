package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.ResourceNotFoundException;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Wallet;
import com.paymybuddy.webapp.repository.PersonRepository;
import com.paymybuddy.webapp.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService implements IWalletService{

    private final Logger logger = LoggerFactory.getLogger(ContactService.class);

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Wallet> getAllWallet() {
        return walletRepository.findAll();
    }
    @Override
    public Wallet getWalletById(Integer id) {
        return walletRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Wallet", "Id", id));
    }
    @Override
    public Wallet getWalletByPersonId(Integer personId){
        List<Wallet> wallets = getAllWallet();
        for (Wallet wallet: wallets){
            if(wallet.getIdPerson().getIdPerson().equals(personId)){
                return wallet;
            }
        }
        return null;
    }
    @Override
    public Float addMoneyToWallet(Integer walletId, Float amount){
        Wallet personWallet = getWalletById(walletId);
        Float actualAmount = personWallet.getAmount();
        float newAmount = actualAmount + amount;
        personWallet.setAmount(newAmount);
        return newAmount;
    }
    @Override
    public Float removeMoneyToWallet(Integer walletId, Float amount){
        Wallet personWallet = getWalletById(walletId);
        Float actualAmount = personWallet.getAmount();
        float newAmount = actualAmount - amount;
        personWallet.setAmount(newAmount);
        return newAmount;
    }
    @Override
    public void addMoneyToWallet(String userEmail, Float amount){
        Person user = personRepository.findByEmail(userEmail);
        Integer userId = user.getIdPerson();

        Wallet userWallet = getWalletByPersonId(userId);
        if(amount > 0){
            userWallet.setAmount(addMoneyToWallet(userWallet.getIdWallet(),amount));
            walletRepository.save(userWallet);
            logger.info("Money add to account success");
        }
        logger.info("Amount need to be above O");
    }

}
