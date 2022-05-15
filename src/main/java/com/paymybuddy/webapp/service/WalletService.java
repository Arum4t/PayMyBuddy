package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Wallet;
import com.paymybuddy.webapp.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService implements IWalletService{

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet saveWallet(Wallet wallet) {
        return null;
    }

    @Override
    public List<Wallet> getAllWallet() {
        return null;
    }

    @Override
    public Wallet getWalletById(Integer id) {
        return null;
    }

    @Override
    public Wallet updateWallet(Wallet wallet, Integer id) {
        return null;
    }

    @Override
    public void deleteWallet(Integer id) {

    }
}
