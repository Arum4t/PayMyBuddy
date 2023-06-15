package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Wallet;

import java.security.Principal;
import java.util.List;

public interface IWalletService {
    Wallet saveWallet (Wallet wallet);
    List<Wallet> getAllWallet();
    Wallet getWalletById(Integer id);
    Wallet updateWallet(Wallet wallet, Integer id);
    void deleteWallet(Integer id);
    Float removeMoneyToWallet(Integer walletId, Float amount);
    Float addMoneyToWallet(Integer walletId, Float amount);
    Wallet getWalletByPersonId(Integer personId);
   // Wallet getCurrentPersonWallet(Principal principal);

}
