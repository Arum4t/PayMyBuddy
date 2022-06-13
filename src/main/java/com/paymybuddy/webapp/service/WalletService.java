package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.exception.ResourceNotFoundException;
import com.paymybuddy.webapp.model.Person;
import com.paymybuddy.webapp.model.Wallet;
import com.paymybuddy.webapp.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class WalletService implements IWalletService{

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private PersonService personService;

    @Override
    public Wallet saveWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

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
    public Wallet updateWallet(Wallet wallet, Integer id) {
        Wallet existingWallet = walletRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Wallet", "Id", id));
        existingWallet.setAmount_wallet(wallet.getAmount_wallet());
        existingWallet.setAccount(wallet.getAccount());
        walletRepository.save(existingWallet);
        return existingWallet;
    }

    @Override
    public void deleteWallet(Integer id) {
       walletRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Wallet", "Id", id));
       walletRepository.deleteById(id);
    }

    public Wallet getCurrentPersonWallet(Principal principal){
        Person person = personService.getPersonByEmail(principal.getName());
        List<Wallet> wallets = getAllWallet();
        for (Wallet wallet: wallets){
            if(wallet.getPerson().getEmail().equals(person.getEmail())){
                return wallet;
            }
        }
        return null;
    }
}
