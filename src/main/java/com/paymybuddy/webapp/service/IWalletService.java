package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Wallet;

import java.util.List;

public interface IWalletService {
    List<Wallet> getAllWallet();
    Wallet getWalletById(Integer id);
    Float removeMoneyToWallet(Integer walletId, Float amount);
    Float addMoneyToWallet(Integer walletId, Float amount);
    Wallet getWalletByPersonId(Integer personId);
    void addMoneyToWallet(String userEmail, Float amount);

}
