package com.paymybuddy.webapp.service;

import com.paymybuddy.webapp.model.Transaction;

import java.security.Principal;
import java.util.List;

public interface ITransactionService {
    void sendMoneyToConnection (String contactEmail, String userEmail, Float amount,String description);
}
