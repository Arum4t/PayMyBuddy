package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.specific.TransactionData;

import java.util.List;

public interface ITransactionService {
    void sendMoneyToConnection (String contactEmail, String userEmail, Float amount,String description);
    List<TransactionData> userTransactionMade(Integer walletId);
    List<TransactionData> userTransactionReceived(Integer walletId);
}
