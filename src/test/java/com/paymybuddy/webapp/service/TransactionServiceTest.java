package com.paymybuddy.webapp.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;
@SpringBootTest
class TransactionServiceTest {

    @Mock
    private TransactionService transactionService;
    @Test
    void sendMoneyToConnection() {
        transactionService.sendMoneyToConnection("bertrand@test.com", "olivier@test.com", 30F, "restaurant");
        verify(transactionService).sendMoneyToConnection("bertrand@test.com", "olivier@test.com", 30F, "restaurant");
    }

    @Test
    void userTransactionMade() {
        transactionService.userTransactionMade(1);
        verify(transactionService).userTransactionMade(1);
    }

    @Test
    void userTransactionReceived() {
        transactionService.userTransactionReceived(1);
        verify(transactionService).userTransactionReceived(1);
    }
}