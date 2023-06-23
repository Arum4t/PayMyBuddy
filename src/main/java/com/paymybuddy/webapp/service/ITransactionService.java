package com.paymybuddy.webapp.service;

public interface ITransactionService {
    void sendMoneyToConnection (String contactEmail, String userEmail, Float amount,String description);
}
