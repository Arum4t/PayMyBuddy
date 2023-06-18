package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.ResourceNotFoundException;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Wallet;
import com.paymybuddy.webapp.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class WalletService implements IWalletService{

    @Autowired
    private WalletRepository walletRepository;

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

}
